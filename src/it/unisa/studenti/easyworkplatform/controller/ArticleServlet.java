package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.studenti.easyworkplatform.model.Article;
import it.unisa.studenti.easyworkplatform.model.ArticleModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ModelInterface<Article> model = new ArticleModelDS();
	private ArticleModelDS modelDs = (ArticleModelDS) model;
    
    public ArticleServlet() {
    	super();
    }
    
    private void sendMessage(String message,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(message);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try{
			if(action != null){
				//INSERT
				if(action.equalsIgnoreCase("insert")){
					String name = request.getParameter("name");
					String pri = request.getParameter("price");
					String description = request.getParameter("description");
					String dur = request.getParameter("duration");
					
					//control if empty
					if (name.equals("") || pri.equals("") || description.equals("") || dur.equals("")){
						sendMessage("empty", response);
						return;
					}

					//control if they respect the format					
					if (!(Pattern.matches("[a-zA-Z]*", name) && Pattern.matches("[a-zA-Z]*", description) && 
						Pattern.matches("[0-9]{2}[.][0-9]{2}", pri) &&	Pattern.matches("[0-9]{3}", dur))){
						sendMessage("regExpError", response);
						return;
					}
					
					double price = Double.parseDouble(pri);
					int duration = Integer.parseInt(dur);
					
					Article newArticle = new Article(name, price, description, duration);
					LinkedList<Article> listArticle = modelDs.findAll();
					for(Article art : listArticle){
						if(art.equals(newArticle)){
							sendMessage("exists", response);
							return;
						}
					}
					
					try{
						model.insert(newArticle);
						sendMessage("insertOk", response);
						return;
					}catch(Exception e){
						sendMessage("cError", response);
						return;
					}
				}
				
				//UPDATE
				if(action.equalsIgnoreCase("update")){
					
					int id = Integer.parseInt(request.getParameter("id"));
					Article oldArticle = modelDs.findByKey(id);
					
					if(oldArticle == null){
						sendMessage("noExists", response);
						return;
					}
					
					String name = request.getParameter("name");
					String pri = request.getParameter("price");
					String description = request.getParameter("description");
					String dur = request.getParameter("duration");
					
					//control if not empty
					if (!(name.equals("") || pri.equals("") || description.equals("") || dur.equals(""))){

						//control if they respect the format						
						if (!(Pattern.matches("[a-zA-Z]*", name) && Pattern.matches("[a-zA-Z]*", description) && 
							Pattern.matches("[0-9]{2}[.][0-9]{2}", pri) &&	Pattern.matches("[0-9]{3}", dur))){
								sendMessage("regExpError", response);
								return;
						}
					}else{
						//if empty, take old attributes
						name = oldArticle.getName();
						pri = oldArticle.getPrice()+"";
						description = oldArticle.getDescription();
						dur = oldArticle.getDuration()+"";
					}

					double price = Double.parseDouble(pri);
					int duration = Integer.parseInt(dur);
					
					Article newArticle = new Article(name, price, description, duration);
					newArticle.setId(oldArticle.getId());
					try{
						modelDs.update(newArticle);
						sendMessage("updateOk", response);
						return;
					}catch(Exception e){
						sendMessage("cError", response);
						return;
					}
				}
				
				//REMOVE
				if(action.equalsIgnoreCase("remove")){
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					Article toRemoveArticle = modelDs.findByKey(id);
					
					if(toRemoveArticle == null){
						sendMessage("noExists", response);
						return;
					}
					
					try{
						modelDs.remove(id);
						sendMessage("removeOk", response);
						return;
					}catch(Exception e){
						sendMessage("cError", response);
						return;
					}
				}
				
				//SEARCH
				if(action.equalsIgnoreCase("search")){
					
					String name = request.getParameter("name");
					String pri = request.getParameter("price");
					
					//control if empty
					if (name.equals("") && pri.equals("")){
						sendMessage("empty", response);
						return;
					}

					//control if they respect the format					
					if (!Pattern.matches("[a-zA-Z]*", name)	|| !Pattern.matches("[0-9]{2}[.][0-9]{2}", pri)){
						sendMessage("regExpError", response);
						return;
					}
					
					double price = Double.parseDouble(pri);
					
					Article article = null;
					LinkedList<Article> listArticle = modelDs.findAll();
					for(Article art : listArticle){
						if(art.getName().equals(name) || art.getPrice() == price){
							article = art;
						}
					}
					
					if(article == null){
						sendMessage("notFound", response);
						return;
					}else{
						request.setAttribute("article", article);
						sendMessage("found", response);
						return;
					}
					
				}
				
				//VIEW LIST
				if(action.equalsIgnoreCase("viewList")){
					
					LinkedList<Article> listArticle = modelDs.findAll();
					
					if(listArticle.isEmpty()){
						sendMessage("emptyList", response);
						return;
					}else{
						request.setAttribute("article", listArticle);
						sendMessage("list", response);
						return;
					}
					
				}
			}
		}catch (SQLException e) {
			this.sendMessage("genericError", response);
		}
	}

}

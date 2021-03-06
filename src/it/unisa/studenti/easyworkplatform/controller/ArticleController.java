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
import javax.servlet.http.HttpSession;

import it.unisa.studenti.easyworkplatform.model.Article;
import it.unisa.studenti.easyworkplatform.model.ArticleModelDS;

/**	
 * Class that handles requests from the browser to the database of an Article
 *  
 * @author AdminEWP
 */
@WebServlet("/ArticleController")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/** 
	 *	Empty Constructor
	 */
    public ArticleController() {
    	super();
    }
    
    /**
	 * Response of the server to the browser
     * @param message to be send to the browser
     * @param response HTTP from server to browser
     * @throws IOException
     */
    private void sendMessage(String message,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(message);
	}
    
    /**
	 * Called by the server to allow a servlet to handle a GET request, for Article's data.
	 * 
	 * @param request an HttpServletRequest object that contains the request the client has made to the servlet
	 * @param response an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws ServletException if an input or output error is detected when the servlet handles the GET request
	 * @throws IOException if the request for the GET could not be handled
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    /**
	 * Called by the server to allow a servlet to handle a POST request, for Article's data.
	 * 
	 * @param request an HttpServletRequest object that contains the request the client has made to the servlet
	 * @param response an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws ServletException if an input or output error is detected when the servlet handles the GET request
	 * @throws IOException if the request for the GET could not be handled
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session	= request.getSession();
		String action		= request.getParameter("action");
		String activity		= (String)session.getAttribute("activityType");
		ArticleModelDS custDs = new ArticleModelDS("dbtest",activity);
		try{
			if(action == null){
				sendMessage("noAction", response);
				return;
			}else{
				//INSERT
				if(action.equalsIgnoreCase("insert")){
					
					String name	 		= request.getParameter("NameA");
					String pri			= request.getParameter("PriceA");
					String description 	= request.getParameter("DescriptionA");
					String dur 			= request.getParameter("DurationA");
					double price = Double.parseDouble(pri);
					int duration = Integer.parseInt(dur);
					Article newArticle = new Article(name, price, description, duration);
					LinkedList<Article> listArticle = custDs.findAll();
					
					
					if(listArticle != null){
						for(Article art : listArticle){
							if(art.equals(newArticle)){
								sendMessage("exists", response);
								return;
							}
						}
					}
					try{
						custDs.insert(newArticle);
						sendMessage("insertOk", response);
						return;
					}catch(Exception e){
						sendMessage("cError", response);
						return;
					}
				}
				
				//UPDATE
				if(action.equalsIgnoreCase("update")){
					
					int id = Integer.parseInt(request.getParameter("idArticle"));
					Article oldArticle = custDs.findByKey(id);
					
					if(oldArticle == null){
						sendMessage("noExists", response);
						return;
					}
					
					String name 		= request.getParameter("modNameA");
					String pri 			= request.getParameter("modPriceA");
					String description	= request.getParameter("modDescriptionA");
					String dur 			= request.getParameter("modDurationA");
					double price		= Double.parseDouble(pri);
					int duration		= Integer.parseInt(dur);
					Article newArticle	= new Article(name, price, description, duration);
					newArticle.setId(oldArticle.getId());
					
					try{
						custDs.update(newArticle);
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
					
					Article toRemoveArticle = custDs.findByKey(id);
					
					if(toRemoveArticle == null){
						sendMessage("noExists", response);
						return;
					}
					
					try{
						custDs.remove(id);
						sendMessage("removeOk", response);
						return;
					}catch(Exception e){
						sendMessage("cError", response);
						return;
					}
				}
				
				//SEARCH
				if(action.equalsIgnoreCase("search")){
					
					String attribute = request.getParameter("attribute");
					String toSearch = request.getParameter("toSearch");
					
					//control if empty
					if (attribute.equals("") && toSearch.equals("")){
						sendMessage("empty", response);
						return;
					}
					
					String regex = "[0-9]{2}[.][0-9]{2}";
					if(attribute.equals("name"))
						regex = "[a-zA-Z]*";

					//control if they respect the format					
					if (!Pattern.matches(regex, toSearch)){
						sendMessage("regExpError", response);
						return;
					}
					
					LinkedList<Article> listArticle = custDs.findByField(attribute, toSearch);
					
					if (listArticle.isEmpty()){
						sendMessage("emptyList", response);
						return;
					}else{
						request.setAttribute("articlesSearched", listArticle);
						sendMessage("listSearched", response);
						return;
					}
					
				}
				
				//VIEW LIST
				if(action.equalsIgnoreCase("viewList")){
					
					LinkedList<Article> listArticle = custDs.findAll();
					
					if(listArticle.isEmpty()){
						sendMessage("emptyList", response);
						return;
					}else{
						session.setAttribute("articles", listArticle);
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

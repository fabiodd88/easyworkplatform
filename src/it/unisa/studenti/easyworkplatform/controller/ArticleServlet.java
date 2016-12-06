package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.studenti.easyworkplatform.model.AccountModelDS;
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
		
//		try{
			if(action != null){
				if(action.equalsIgnoreCase("insert")){
					
				}
			}
//		}catch (SQLException e) {
//			this.sendMessage("genericError", response);
//		}
	}

}

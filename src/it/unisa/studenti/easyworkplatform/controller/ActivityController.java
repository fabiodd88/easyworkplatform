package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.studenti.easyworkplatform.model.Activity;
import it.unisa.studenti.easyworkplatform.model.ActivityModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;

/**
 * 	ActivityController
 * 	Class that handles requests from the browser to the database of an Activity
 * 	@author AdminEWP
 *
 */
@WebServlet("/ActivityController")
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ModelInterface<Activity> model = new ActivityModelDS();
	private ActivityModelDS modelDs = (ActivityModelDS) model;

	/** 
	 *	Empty Constructor
	 */
    public ActivityController() {
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
     *	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
     *	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
//		try {
//			if(action != null){
//				//INSERT
//				if (action.equalsIgnoreCase("insert"))
//				{
//					String	email 	 = request.getParameter("email");
//					String	password = request.getParameter("password");
//					User user = new User(null,null,null);
//					user.setEmail(email);
//					user.setPassword(password);
//					ActivityModelDS modelDs = (ActivityModelDS) model;					
//					if(modelDs.findByName(email) != null ){
//						sendMessage("exist", response);
//						return;
//					}
//					try{
//						model.insert(user);
//						sendMessage("insertOk", response);
//						return;
//					}catch(Exception e){
//						sendMessage("cError", response);
//						return;
//					}
//					
//				}
//			}
//		} catch (SQLException e) {
//			this.sendMessage("genericError", response);
//		}
	}

}

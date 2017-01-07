package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.studenti.easyworkplatform.model.AccountModelDS;
import it.unisa.studenti.easyworkplatform.model.Activity;
import it.unisa.studenti.easyworkplatform.model.ActivityModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;
import it.unisa.studenti.easyworkplatform.model.User;

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
		
		String 		action 	= request.getParameter("action");
		HttpSession session = request.getSession();
		
		try {
			if (action == null) {
				sendMessage("noAction", response);
				return;
			} else {

				// INSERT
				if (action.equalsIgnoreCase("insert")){
					
					int userId = Integer.parseInt(request.getParameter("userId"));
					AccountModelDS modelDsAccount = new AccountModelDS();
					User user = modelDsAccount.findByKey(userId);
					
					if(user == null){
						sendMessage("notFound", response);
						return;
					}
					
					String activityName 	= request.getParameter("activityName"); 
					String vatCode 			= request.getParameter("vatCode"); 
					String tipology 		= request.getParameter("tipology"); 
					String activityAddress 	= request.getParameter("activityAddress"); 
					String activityCity 	= request.getParameter("activityCity"); 
					String activityCivicNumber = request.getParameter("activityCivicNumber"); 
					String activityCap		= request.getParameter("activityCap"); 
					String activityProvince	= request.getParameter("activityProvince");
					String address			= activityAddress+", "+activityCivicNumber;
					
					//Control if empty
					if (
							activityName.equals("")	||	vatCode.equals("")				|| 
							tipology.equals("") 	||	activityAddress.equals("") 		|| 
							activityCity.equals("") ||	activityCivicNumber.equals("")	||
							activityCap.equals("")	||	activityProvince.equals("")		
						){
							sendMessage("empty", response);
							return;
					}
					
					
					
					int cap = Integer.parseInt(activityCap);
					
					Activity activity = new Activity(activityName, tipology, address, activityCity, activityProvince, cap, vatCode, userId);
					
					LinkedList<Activity> listActivity = modelDs.findAll();
					
					for (Activity act : listActivity) {
						if(act.equals(activity)){
							sendMessage("exist", response);
							return;
						}
					}
					
					try{
						modelDs.insert(activity);
						sendMessage("insertOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}
				}
				
			}
		} catch (SQLException e) {
			this.sendMessage("genericError", response);
		}
	}

}

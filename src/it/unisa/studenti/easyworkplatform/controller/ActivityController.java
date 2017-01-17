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

import it.unisa.studenti.easyworkplatform.model.Activity;
import it.unisa.studenti.easyworkplatform.model.ActivityModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;

/**
 * Class that handles requests from the browser to the database of an Activity
 * 	
 * @author AdminEWP
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
	 * Called by the server to allow a servlet to handle a GET request, for Activity's data.
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
	 * Called by the server to allow a servlet to handle a POST request, for Activity's data.
	 * 
	 * @param request an HttpServletRequest object that contains the request the client has made to the servlet
	 * @param response an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws ServletException if an input or output error is detected when the servlet handles the GET request
	 * @throws IOException if the request for the GET could not be handled
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

					String uid				= (String)session.getAttribute("userId");
					String activityName 	= request.getParameter("activityName"); 
					String vatCode 			= request.getParameter("vatCode"); 
					String tipology 		= request.getParameter("tipology"); 
					String activityAddress 	= request.getParameter("activityAddress"); 
					String activityCity 	= request.getParameter("activityCity"); 
					String activityCivicNumber = request.getParameter("activityCivicNumber"); 
					String activityCap		= request.getParameter("activityCap"); 
					String activityProvince	= request.getParameter("activityProvince");
					String address			= activityAddress+", "+activityCivicNumber;
//
//					//Control if empty
//					if (
//							activityName.equals("")	||	vatCode.equals("")				|| 
//							tipology.equals("") 	||	activityAddress.equals("") 		|| 
//							activityCity.equals("") ||	activityCivicNumber.equals("")	||
//							activityCap.equals("")	||	activityProvince.equals("")		
//							){
//						sendMessage("empty", response);
//						return;
//					}


					int userId 	= Integer.parseInt(uid);
					int cap 	= Integer.parseInt(activityCap);

					Activity activity = new Activity(activityName, tipology, address, activityCity, activityProvince, cap, vatCode, userId);

					LinkedList<Activity> listActivity = modelDs.findAll();

					if(listActivity !=null){
						for (Activity act : listActivity) {
							if(act.equals(activity)){
								sendMessage("exist", response);
								return;
							}
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
				
				//VIEW LIST
				if(action.equalsIgnoreCase("viewList")){
					
					LinkedList<Activity> listActivity = modelDs.findAll();
					
					if(listActivity.isEmpty()){
						sendMessage("emptyList", response);
						return;
					}else{
						session.setAttribute("articles", listActivity);
						sendMessage("list", response);
						return;
					}
					
				}
				
				if(action.equalsIgnoreCase("findById")){
					int id = (int) session.getAttribute("userId");
					Activity activity = model.findByKey(id);
					if(activity != null){
						String servizio;
						String articoli;
						String active = activity.getType();
						if(active.equalsIgnoreCase("pizzeria")){ 					servizio 	=  "Comanda";		articoli	= "Menu";				}
						else if(active.equalsIgnoreCase("lavanderia")){ 			servizio 	=  "Ricezione";		articoli	= "Capo";				}
						else if(active.equalsIgnoreCase("centro estetico")){		servizio 	=  "Appuntamento";	articoli	= "Trattamento";		}
						else if(active.equalsIgnoreCase("centro riparazioni")){ 	servizio	=  "Riparazione";	articoli	= "Servizio Assistenza";}
						else{ 														servizio	=  "Servizio";		articoli	= "Articoli";			}
						session.setAttribute("activityName", activity.getName());
						session.setAttribute("activityType", active);
						session.setAttribute("servizio", servizio);
						session.setAttribute("articolo", articoli);
						sendMessage("findIt", response);
					}
					else{
						sendMessage("nofind", response);
					}
				}
				
				
				
			}
		} catch (SQLException e) {
			this.sendMessage("genericError", response);
		}
	}


}



package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.studenti.easyworkplatform.model.Payment;
import it.unisa.studenti.easyworkplatform.model.PaymentModelDS;

/**
 * Class that handles requests from the browser to the database of a Payment
 * 	
 * @author AdminEWP
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/** 
	 *	Empty Constructor
	 */
    public PaymentController() {
        // TODO Auto-generated constructor stub
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
	 * Called by the server to allow a servlet to handle a GET request, for Payment's data.
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
	 * Called by the server to allow a servlet to handle a POST request, for Payment's data.
	 * 
	 * @param request an HttpServletRequest object that contains the request the client has made to the servlet
	 * @param response an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws ServletException if an input or output error is detected when the servlet handles the GET request
	 * @throws IOException if the request for the GET could not be handled
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session 	= request.getSession();
		String activity			= (String)session.getAttribute("activityType");
		String 	action 			= request.getParameter("action");
		PaymentModelDS custDs 	= new PaymentModelDS("dbtest",activity);
		try{
			if(action == null){
				sendMessage("noAction", response);
				return;
			}else{

				// INSERT
				if (action.equalsIgnoreCase("insert")){
					
					String customerId	= request.getParameter("modCustomerP");
					String id			= request.getParameter("modServiceP");
					String articleId	= request.getParameter("modServiceTypeP");
					String amount		= request.getParameter("modAmountP");
					String date			= request.getParameter("modDateP");
					
					
					Date date2 		= Date.valueOf(date);
					double amount2	= Double.parseDouble(amount);
					int customerId2 = Integer.parseInt(customerId);
					int id2 		= Integer.parseInt(id);
					int articleId2 	= Integer.parseInt(articleId);
					
					Payment payment = new Payment(amount2, date2, id2, customerId2, articleId2);
					LinkedList<Payment> listPayment = custDs.findAll();

					if(listPayment != null){
						for (Payment pay : listPayment) {
							if(pay.equals(payment)){
								sendMessage("exists", response);
								return;
							}
						}
					}
					try {
						custDs.insert(payment);
						sendMessage("insertOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}
				}
				
				
				// REMOVE
				if (action.equalsIgnoreCase("remove")){
					int id = Integer.parseInt(request.getParameter("id"));
					
					Payment toRemove = custDs.findByKey(id);
					
					if(toRemove == null){
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
				
				
				// SEARCH
				if (action.equalsIgnoreCase("update")){
					
					
					String attribute = request.getParameter("attribute");
					String toSearch = request.getParameter("toSearch");

					
					LinkedList<Payment> listPayment = custDs.findByField(attribute, toSearch);
					
					if (listPayment.isEmpty()){
						sendMessage("emptyList", response);
						return;
					}else{
						request.setAttribute("paymentsSearched", listPayment);
						sendMessage("listSearched", response);
						return;
					}
					
				}
				// VIEW LIST
				if (action.equalsIgnoreCase("viewList")){
					LinkedList<Payment> listPayment = custDs.findAll();
					
					if (listPayment.isEmpty()){
						session.setAttribute("services", listPayment);
						sendMessage("emptyList", response);
						return;
					}else{
						session.setAttribute("payments", listPayment);
						sendMessage("list", response);
						return;
					}
				}
			}
		} catch (SQLException e) {
			this.sendMessage("genericError", response);
		}
	}

}

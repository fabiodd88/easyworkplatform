package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.studenti.easyworkplatform.model.Customer;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;
import it.unisa.studenti.easyworkplatform.model.Payment;
import it.unisa.studenti.easyworkplatform.model.PaymentModelDS;

/**	PaymentController
 * 	Class that handles requests from the browser to the database of a Payment
 * 	@author AdminEWP
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ModelInterface<Payment> model = new PaymentModelDS();
	private PaymentModelDS modelDs = (PaymentModelDS) model;

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
     *	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
     *	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session 	= request.getSession();
		String 	activity 		= request.getParameter("activity");
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
					
//					// control if empty
//					if (
//						date.equals("")	|| amount.equals("")	|| 
//						customerId.equals("") || customerId.equals("")		|| sid.equals("")
//						){
//							sendMessage("empty", response);
//							return;
//					}
					
//					//control if they respect the format
//					if ( ! (Pattern.matches("(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)", date) && Pattern.matches("[0-9]{2}[.][0-9]{2}", amount) && Pattern.matches("[0-9]*", scid) && 
//							Pattern.matches("[0-9]*", said) && Pattern.matches("[0-9]*", sid)) ){
//								sendMessage("regExpError", response);
//								return;
//					}
					
					Date date2 		= Date.valueOf(date);
					double amount2	= Double.parseDouble(amount);
					int customerId2 = Integer.parseInt(customerId);
					int id2 		= Integer.parseInt(id);
					int articleId2 	= Integer.parseInt(articleId);
					
					Payment payment = new Payment(amount2, date2, id2, customerId2, articleId2);
					LinkedList<Payment> listPayment = modelDs.findAll();

					if(listPayment != null){
						for (Payment pay : listPayment) {
							if(pay.equals(payment)){
								sendMessage("exists", response);
								return;
							}
						}
					}
					try {
						modelDs.insert(payment);
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
					
					Payment toRemove = modelDs.findByKey(id);
					
					if(toRemove == null){
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
				
				
				// SEARCH
				if (action.equalsIgnoreCase("update")){
					
					
					String attribute = request.getParameter("attribute");
					String toSearch = request.getParameter("toSearch");
					
//					//control if empty
//					if (attribute.equals("") && toSearch.equals("")){
//						sendMessage("empty", response);
//						return;
//					}
//					
//					String regex = "(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)";
//					if (attribute.equals("serviceCustomerId")) regex = "[0-9]*";
//					
//					if(!(Pattern.matches(regex, toSearch))){
//						sendMessage("regExpError", response);
//						return;
//					}
					
					LinkedList<Payment> listPayment = modelDs.findByField(attribute, toSearch);
					
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
					LinkedList<Payment> listPayment = modelDs.findAll();
					
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

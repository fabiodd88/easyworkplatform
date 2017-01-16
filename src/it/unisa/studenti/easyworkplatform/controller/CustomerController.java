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
import it.unisa.studenti.easyworkplatform.model.Customer;
import it.unisa.studenti.easyworkplatform.model.CustomerModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;

/**	CustomerController
 * 	Class that handles requests from the browser to the database of a Customer
 * 	@author AdminEWP
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/** 
	 *	Empty Constructor
	 */
    public CustomerController() {
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
		
		HttpSession session		= request.getSession();
		String action 			= request.getParameter("action");
		String activity			= (String)session.getAttribute("activityType");
		CustomerModelDS custDs 	= new CustomerModelDS("dbtest",activity);
		
		try {
			if (action == null) {
				sendMessage("noAction", response);
				return;
			} else {

				// INSERT
				if (action.equalsIgnoreCase("insert")) {
					
					String name 		= request.getParameter("NameCl");
					String surname 		= request.getParameter("SurnameCl");
					String birthDate 	= request.getParameter("BirthCl");
					String birthPlace	= request.getParameter("PlaceCl");
					String address		= request.getParameter("AddressCl");
					String civicNumber	= request.getParameter("CivicNumber");
					String city			= request.getParameter("CityCl");
					String province		= request.getParameter("ProvinceCl");
					String cap 			= request.getParameter("CapCl");
					String email		= request.getParameter("EmailCl");
					String newsletter 	= request.getParameter("Newsletter");
					String phoneNumber 	= request.getParameter("PhoneCl");

					
					String address1 = address+", "+civicNumber;
					int CAP = Integer.parseInt(cap);
					Date bd = Date.valueOf(birthDate);
					int nl 	= 0;
					
					
					Customer customer = new Customer(name, surname, bd, birthPlace, address1, city, province, CAP, nl, phoneNumber, email);
					LinkedList<Customer> listCustomer = custDs.findAll();
					
					if(listCustomer != null){
						for (Customer cus : listCustomer) {
							if(cus.equals(customer)){
								sendMessage("exists", response);
								return;
							}
						}
					}
					try {
						custDs.insert(customer);
						sendMessage("insertOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}

				}
				
				// UPDATE
				if (action.equalsIgnoreCase("update")){
					
					int id = Integer.parseInt(request.getParameter("idCustomer"));
					
					Customer oldCustomer = custDs.findByKey(id);
					
					if(oldCustomer == null){
						sendMessage("noExist", response);
						return;
					}
					
					String name 		= request.getParameter("modNameCl");
					String surname 		= request.getParameter("modSurnameCl");
					String birthDate 	= request.getParameter("modBirthCl");
					String birthPlace	= request.getParameter("modPlaceCl");
					String address		= request.getParameter("modAddressCl");
					String city			= request.getParameter("modCityCl");
					String province		= request.getParameter("modProvinceCl");
					String cap 			= request.getParameter("modCapCl");
					String email		= request.getParameter("modEmailCl");
					String newsletter 	= request.getParameter("newsletter");
					String phoneNumber 	= request.getParameter("modPhoneCl");
					
					
					int CAP = Integer.parseInt(cap);
					Date bd = Date.valueOf(birthDate);
					int nl = 0;
					
					Customer newCustomer = new Customer(id, name, surname, bd, birthPlace, address, city, province, CAP, nl, phoneNumber, email);
					newCustomer.setId(oldCustomer.getId());
					try{
						custDs.update(newCustomer);
						sendMessage("updateOk", response);
						return;
					}catch(Exception e){
						sendMessage("cError", response);
						return;
					}
				}
				
				// REMOVE
				if (action.equalsIgnoreCase("remove")){
					int id = Integer.parseInt(request.getParameter("id"));
					
					Customer toRemove = custDs.findByKey(id);
					
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
				if (action.equalsIgnoreCase("search")){
					
					String attribute = request.getParameter("attribute");
					String toSearch = request.getParameter("toSearch");
					
					//control if empty
					if (attribute.equals("") && toSearch.equals("")){
						sendMessage("empty", response);
						return;
					}
					
					
					LinkedList<Customer> listCustomer = custDs.findByField(attribute, toSearch);
					
					if (listCustomer.isEmpty()){
						sendMessage("emptyList", response);
						return;
					} else{
						request.setAttribute("customersSearched", listCustomer);
						sendMessage("listSearched", response);
						return;
					}
				}
				
				// VIEW LIST
				if (action.equalsIgnoreCase("viewList")){
					LinkedList<Customer> listCustomer = custDs.findAll();
					if (listCustomer.isEmpty()){
						sendMessage("emptyList", response);
						return;
					} else{
						session.setAttribute("customers", listCustomer);
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

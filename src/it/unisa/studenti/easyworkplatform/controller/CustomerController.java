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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import it.unisa.studenti.easyworkplatform.model.Account;
import it.unisa.studenti.easyworkplatform.model.ArticleModelDS;
import it.unisa.studenti.easyworkplatform.model.Customer;
import it.unisa.studenti.easyworkplatform.model.CustomerModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;
import it.unisa.studenti.easyworkplatform.model.User;

/**	CustomerController
 * 	Class that handles requests from the browser to the database of a Customer
 * 	@author AdminEWP
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ModelInterface<Customer> model = new CustomerModelDS();
	private CustomerModelDS modelDs = (CustomerModelDS) model;
	
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
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		try {
			if (action == null) {
				sendMessage("noAction", response);
				return;
			} else {

				// INSERT
				if (action.equalsIgnoreCase("insert")) {
					
					String name = request.getParameter("name");
					String surname = request.getParameter("surname");
					String birthDate = request.getParameter("birthDate");
					String birthPlace = request.getParameter("birthPlace");
					String address = request.getParameter("address");
					String city = request.getParameter("city");
					String province = request.getParameter("province");
					String cap = request.getParameter("cap");
					String email = request.getParameter("email");
					String newsletter = request.getParameter("newsletter");
					String phoneNumber = request.getParameter("phoneNumber");
					
					// control if empty
					if (name.equals("") || surname.equals("") || birthDate.equals("") || 
						birthPlace.equals("") || address.equals("") || city.equals("") || 
						province.equals("") || cap.equals("") || email.equals("") ||
						newsletter.equals("") || phoneNumber.equals("")){
							sendMessage("empty", response);
							return;
					}
					
					//control if they respect the format
					if ( ! (Pattern.matches("[a-zA-Z]*", name) && Pattern.matches("[a-zA-Z]*", surname) && Pattern.matches("(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)",birthDate) && 
							Pattern.matches("[a-zA-Z]*", birthPlace) && Pattern.matches("[a-zA-Z 0-9]*", address) && Pattern.matches("[a-zA-Z]*", province) &&
							Pattern.matches("[a-zA-Z]*", city) && Pattern.matches("[0-9]{5}", cap) && Pattern.matches("[0-9]*", phoneNumber) &&
							Pattern.matches("[a-zA-Z]*[@][a-zA-Z]*[.][a-zA-Z]*", email) && Pattern.matches("[a-zA-Z0-9]*", newsletter))){
								sendMessage("regExpError", response);
								return;
					}
					
					int CAP = Integer.parseInt(cap);
					Date bd = Date.valueOf(birthDate);
					int nl = Integer.parseInt(newsletter);
					
					
					Customer customer = new Customer(name, surname, bd, birthPlace, address, city, province, CAP, nl, phoneNumber, email);
					LinkedList<Customer> listCustomer = modelDs.findAll();
					for (Customer cus : listCustomer) {
						if(cus.equals(customer)){
							sendMessage("exists", response);
							return;
						}
					}
					
					try {
						modelDs.insert(customer);
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

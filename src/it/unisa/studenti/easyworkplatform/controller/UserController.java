package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.studenti.easyworkplatform.model.Account;
import it.unisa.studenti.easyworkplatform.model.AccountModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;
import it.unisa.studenti.easyworkplatform.model.User;

/*	UserController
 * 	Class that handles requests from the browser to the database of a User
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static ModelInterface<User> model = new AccountModelDS();
	private AccountModelDS modelDs = (AccountModelDS) model;

	// Empty Constructor
	public UserController() {
		super();
	}

	// Response of the server to the browser 
    private void sendMessage(String message,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(message);
	}
    
    // Handle the request in "GET" method
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	// Handle the request in "POST" method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
					String taxCode = request.getParameter("taxCode");
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					String passwordCtrl = request.getParameter("password");
					String secondKey = request.getParameter("secondKey");
					String secondKeyCtrl = request.getParameter("secondKeyCtrl");
					
					// control if empty
					if (name.equals("") || surname.equals("") || birthDate.equals("") || 
						birthPlace.equals("") || address.equals("") || city.equals("") || 
						province.equals("") || cap.equals("") || taxCode.equals("") || 
						email.equals("") || password.equals("") || secondKey.equals("") ||
						passwordCtrl.equals("") || secondKeyCtrl.equals("")){
							sendMessage("empty", response);
							return;
					}
					
					//password and secondkey are the same
					if(password.equals(secondKey)){
						sendMessage("samePassword", response);
						return;
					}
					
					//password and password control aren't the same
					if(!password.equals(passwordCtrl)){
						sendMessage("pswCtrl", response);
						return;
					}
					
					//secondkey and secondKey Control aren't the same
					if(secondKey.equals(secondKeyCtrl)){
						sendMessage("sKeyCtrl", response);
						return;
					}
					
					
					//control if they respect the format
					if ( ! (Pattern.matches("[a-zA-Z]*", name) && Pattern.matches("[a-zA-Z]*", surname) && Pattern.matches("(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)",birthDate) && 
							Pattern.matches("[a-zA-Z]*", birthPlace) && Pattern.matches("[a-zA-Z 0-9]*", address) && Pattern.matches("[a-zA-Z]*", province) &&
							Pattern.matches("[a-zA-Z]*", city) && Pattern.matches("[0-9]{5}", cap) && Pattern.matches("[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]", taxCode) &&
							Pattern.matches("[a-zA-Z]*[@][a-zA-Z]*[.][a-zA-Z]*", email) && Pattern.matches("[a-zA-Z0-9]{8,32}", password) && Pattern.matches("[a-zA-Z0-9]{8,32}", secondKey))){
								sendMessage("regExpError", response);
								return;
					}
					
					int CAP = Integer.parseInt(cap);
					Date bd = Date.valueOf(birthDate);
					String cryptedPassword = toSHA1(password.getBytes());
					String cryptedSecondKey = toSHA1(secondKey.getBytes());
					
					
					Account account = new Account(email, cryptedPassword, cryptedSecondKey);
					User user = new User(account, name, surname, bd, birthPlace, address, city, province, CAP, taxCode);
					
					
					if (modelDs.findByEmail(email) != null) {
						sendMessage("exist", response);
						return;
					}
					try {
						model.insert(user);
						sendMessage("insertOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}

				}

				// LOGIN
				if (action.equalsIgnoreCase("login")) {
					
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					
					User user = modelDs.findByEmail(email);
					if (user == null) {
						sendMessage("noUser", response);
						return;
					}
					String dbPassword = user.getPassword();
					String hashed = toSHA1(password.getBytes());
					if (dbPassword != null) {
						if (dbPassword.equals(hashed)){
							session.setAttribute("user", user);
							sendMessage("login", response);
							return;
						}
						else{
							sendMessage("noExist", response);
							return;
						}
					}
				}

				// LOGOUT
				if (action.equalsIgnoreCase("logout")) {
					User user = (User) session.getAttribute("user");
					if (user != null) {
						response.sendRedirect("/ProgettoPW/index.jsp");
						session.invalidate();
						return;
					} else{
						sendMessage("genericError", response);
						return;
					}
				}

				// UPDATE
				if (action.equalsIgnoreCase("update")) {
					
				}
				
				// REMOVE
				if (action.equalsIgnoreCase("remove")) {
				}
				
				// Recupera pass
				if (action.equalsIgnoreCase("retrievePassword")) {
				}
				
				// Recupera login
				if (action.equalsIgnoreCase("retrieveLogin")) {
				}
				
				
			}
		} catch (SQLException e) {
			this.sendMessage("genericError", response);
		}
	}

	//Encrypt data
	public static String toSHA1(byte[] convertme) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(md.digest(convertme));
	}

}

package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.studenti.easyworkplatform.model.Account;
import it.unisa.studenti.easyworkplatform.model.AccountModelDS;
import it.unisa.studenti.easyworkplatform.model.Activity;
import it.unisa.studenti.easyworkplatform.model.ActivityModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;
import it.unisa.studenti.easyworkplatform.model.User;

/**
 * Class that handles requests from the browser to the database of a User
 * 
 * @author AdminEWP
 *
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static ModelInterface<User> model = new AccountModelDS();
	private AccountModelDS modelDs = (AccountModelDS) model;

	/** 
	 *	Empty Constructor
	 */
	public UserController() {
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
	 * Called by the server to allow a servlet to handle a GET request, for User's data.
	 * 
	 * @param request an HttpServletRequest object that contains the request the client has made to the servlet
	 * @param response an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws ServletException if an input or output error is detected when the servlet handles the GET request
	 * @throws IOException if the request for the GET could not be handled
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null ){
			request.getRequestDispatcher("attivita.jsp").forward(request, response);

		}
		else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * Called by the server to allow a servlet to handle a POST request, for User's data.
	 * 
	 * @param request an HttpServletRequest object that contains the request the client has made to the servlet
	 * @param response an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws ServletException if an input or output error is detected when the servlet handles the GET request
	 * @throws IOException if the request for the GET could not be handled
	 */
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

					String name 		= request.getParameter("name");
					String surname		= request.getParameter("surname");
					String birthDate	= request.getParameter("birthDate");
					String taxCode		= request.getParameter("taxCode");
					String birthPlace	= request.getParameter("birthPlace");
					String address		= request.getParameter("address");
					String civicNumber	= request.getParameter("civicNumber");
					String city			= request.getParameter("city");
					String province		= request.getParameter("province");
					String cap			= request.getParameter("cap");
					String email		= request.getParameter("email");
					String password		= request.getParameter("password");
					String passwordCtrl = request.getParameter("confPassword");
					String secondKey	= request.getParameter("secondKey");
					String secondKeyCtrl= request.getParameter("confSecondKey");
					String address1 	= address+", "+civicNumber;



					//password and password control aren't the same
					if(!password.equals(passwordCtrl)){
						sendMessage("pswCtrl", response);
						return;
					}



					int CAP = Integer.parseInt(cap);
					Date bd = Date.valueOf(birthDate);
					String cryptedPassword 	= toSHA1(password.getBytes());
					String cryptedSecondKey = toSHA1(secondKey.getBytes());
					Account account	= new Account(email, cryptedPassword, cryptedSecondKey);
					User 	user	= new User(account, name, surname, bd, birthPlace, address1, city, province, CAP, taxCode);
					
		
					if (modelDs.findByEmail(email) != null) {
						sendMessage("exist", response);
						return;
					}
					try {
						model.insert(user);
						User userFind = modelDs.findByEmail(email);
						if (userFind != null) {
							String idUser = ""+userFind.getId();
							session.setAttribute("userId", idUser);
							ServletContext context = this.getServletContext();
							RequestDispatcher dispatcher = context.getRequestDispatcher("/ActivityController");
							dispatcher.forward(request, response);
						}
						sendMessage("insertOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}

				}

				// LOGIN
				if (action.equalsIgnoreCase("login")) {


					String email	= (String) request.getParameter("email");
					String password = (String) request.getParameter("password");
					User user = modelDs.findByEmail(email);
					if (user == null) {
						sendMessage("noUser", response);
						return;
					}
					String dbPassword = user.getPassword();
					String hashed 	  = toSHA1(password.getBytes());
					if (dbPassword != null) {
						if (dbPassword.equals(hashed)){
							session.setAttribute("user", user);
							String userName = user.getName()+" "+user.getSurname();
							session.setAttribute("UserName", userName);
							session.setAttribute("userId",user.getId());
							sendMessage("loginOk", response);
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
						response.sendRedirect("UserController");
						session.invalidate();
						return;
					} else{
						sendMessage("genericError", response);
						return;
					}
				}

				// FORGET PASSWORD
				if (action.equalsIgnoreCase("retrievePassword")) {
					String email = request.getParameter("email");

					if (email.equals("")){
						sendMessage("empty", response);
						return;
					}

					if (!Pattern.matches("[a-zA-Z]*[@][a-zA-Z]*[.][a-zA-Z]*", email)){
						sendMessage("errorEmail", response);
						return;
					}

					User user = modelDs.findByEmail(email);
					if (user == null) {
						sendMessage("noUser", response);
						return;
					}else{
						// come inviamo l'email??

						sendMessage("emailSent", response);
						return;
					}

				}

				// FORGET LOGIN
				if (action.equalsIgnoreCase("retrieveLogin")) {

					String attribute = request.getParameter("attribute");
					String toRetrieve = request.getParameter("toRetrieve");

					if (attribute.equals("") || toRetrieve.equals("")){
						sendMessage("empty", response);
						return;
					}

					User user = null;

					String regex = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";

					if (attribute.equals("vatNumber")) {
						regex = "";
						if(! Pattern.matches(regex, toRetrieve)){
							sendMessage("regExpError", response);
							return;
						}
						ActivityModelDS modelDsActivity = new ActivityModelDS();

						LinkedList<Activity> listActivity = modelDsActivity.findByField("vat_number", toRetrieve);

						if(!listActivity.isEmpty()){
							Activity activity = listActivity.getFirst();
							LinkedList<User> listUser = modelDs.findAll();
							for (User us : listUser) {
								if(activity.getUserId() == us.getId()){
									user = us;
									break;
								}
							}

						}
					}
					else{
						if(! Pattern.matches(regex, toRetrieve)){
							sendMessage("regExpError", response);
							return;
						}
						LinkedList<User> listUser = modelDs.findAll();

						for (User us : listUser) {
							if (us.getTaxCode().equalsIgnoreCase(toRetrieve)){
								user = us;
								break;
							}
						}
					}

					if(user == null){
						sendMessage("notFound", response);
						return;
					}else {
						// come inviamo l'email??

						sendMessage("emailSent", response);
						return;	
					}
				}

				// UPDATE
				if (action.equalsIgnoreCase("update")) {
					String id1 	= request.getParameter("id");
					int 	id 	= Integer.parseInt(id1);
					User oldUser = modelDs.findByKey(id);

					if(oldUser == null){
						sendMessage("notFound", response);
						return;
					}



					String name 		= request.getParameter("name");
					String surname		= request.getParameter("surname");
					String birthDate	= request.getParameter("birthDate");
					String birthPlace 	= request.getParameter("birthPlace");
					String address 		= request.getParameter("address");
					String city 		= request.getParameter("city");
					String province 	= request.getParameter("province");
					String cap 			= request.getParameter("cap");
					String taxCode 		= request.getParameter("taxCode");
					String email		= request.getParameter("email");
					String password		= request.getParameter("password");
					String passwordCtrl = request.getParameter("confPassword");
					String secondKey	= request.getParameter("secondKey");
					String secondKeyCtrl= request.getParameter("confSecondKey");



					//password and password control aren't the same
					if(!password.equals(passwordCtrl)){
						sendMessage("pswCtrl", response);
						return;
					}



					int CAP = Integer.parseInt(cap);
					Date bd = Date.valueOf(birthDate);
					String cryptedPassword = toSHA1(password.getBytes());
					String cryptedSecondKey = toSHA1(secondKey.getBytes());


					Account account = new Account(email, cryptedPassword, cryptedSecondKey);
					User newUser 	= new User(account, name, surname, bd, birthPlace, address, city, province, CAP, taxCode);

					newUser.setId(oldUser.getId());

					try {
						model.update(newUser);
						sendMessage("updateOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}


				}
			}
		}catch (SQLException e) {
			this.sendMessage("genericError", response);
		}
	}

	/**
	 * Encrypt data into String type
	 * @param convertme array of bytes to be encrypt
	 * @return encrypted bytes
	 */
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

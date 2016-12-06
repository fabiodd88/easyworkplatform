package it.unisa.studenti.easyworkplatform.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.studenti.easyworkplatform.model.AccountModelDS;
import it.unisa.studenti.easyworkplatform.model.ModelInterface;
import it.unisa.studenti.easyworkplatform.model.User;

/**
 * Servlet implementation class UserControl
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static ModelInterface<User> model = new AccountModelDS();
	private AccountModelDS modelDs = (AccountModelDS) model;


	public UserController() {
		super();
	}

	private void sendMessage(String message,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print(message);
	}

	public static String toSHA1(byte[] convertme) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		}
		catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		return new String(md.digest(convertme));
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String action = request.getParameter("action");

		try {
			if (action != null)
			{
				//INSERT
				if (action.equalsIgnoreCase("insert"))
				{
					String	email 	 = request.getParameter("email");
					String	password = request.getParameter("password");
					User user = new User(null,null,null);
					user.setEmail(email);
					user.setPassword(password);
					AccountModelDS modelDs = (AccountModelDS) model;					
					if(modelDs.findByName(email) != null )
					{
						sendMessage("exist", response);
						return;
					}
					try{
						model.insert(user);
						sendMessage("insertOk", response);
						return;
					}catch(Exception e){
						sendMessage("cError", response);
						return;
					}
					
				} 
				//UPDATE
				else if(action.equalsIgnoreCase("update"))
				{
					String newPassword = request.getParameter("newPassword");
					if(newPassword.equals("") || newPassword == null){
						this.sendMessage("genericError", response);
						return;
					}
					User user = new User(null,null,null);
					HttpSession session = request.getSession();
					int idUser = (Integer) session.getAttribute("userId");    
					user.setPassword(newPassword);
					user.setId(idUser);
					try {
						model.update(user);
					}
					catch(Exception e){
						sendMessage("genericError", response);			
					}
					
				}
				//lOGIN
				else if(action.equalsIgnoreCase("login"))
				{
					HttpSession session = request.getSession();
					String 	email 		= (String) request.getParameter("email"); 
					String 	password 	= (String) request.getParameter("password"); 
					User 	user 		= modelDs.findByName(email);
					if(user == null) 
					{
						sendMessage("noUser", response);
						return;
					}
					String DbPassword = user.getPassword(); 
					String hashed	= toSHA1(password.getBytes());
					if(DbPassword != null)
					{
						if(DbPassword.equals(hashed))
						{
							session.setAttribute("user", user);
						}
						else sendMessage("noExist", response);
					}
				}
				
				//LOGOUT
				else if(action.equalsIgnoreCase("logout"))
				{
					HttpSession session = request.getSession();
					User user = (User) session.getAttribute("user");
					if(user != null)
					{ 
						response.sendRedirect("/ProgettoPW/index.jsp");
						session.invalidate();
					}
					else{
						sendMessage("genericError", response);
					}

				}
				
				//REMOVE
				else if(action.equalsIgnoreCase("remove")){
					int id = Integer.parseInt(request.getParameter("id"));
					
					HttpSession session = request.getSession();
					User u = (User)session.getAttribute("user");
					
					if (u != null && u.getSecondKey() == "qua ci devo pensare") //sono loggato e sono admin
					{
						try{
							model.remove(id);
							sendMessage("remove", response);  //la remove è riuscita
						}
						catch(Exception e){
							sendMessage("dbError", response);//errore di remove
						}
					}
					else sendMessage("accessDenied", response); //non sono loggato o non sono admin 
				}				
			}
		} catch (SQLException e) {
			this.sendMessage("genericError", response);
		}
	}



}

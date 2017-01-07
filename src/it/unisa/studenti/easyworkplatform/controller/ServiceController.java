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

import it.unisa.studenti.easyworkplatform.model.ModelInterface;
import it.unisa.studenti.easyworkplatform.model.Service;
import it.unisa.studenti.easyworkplatform.model.ServiceModelDS;

/**	ServiceController
 * 	Class that handles requests from the browser to the database of a Service
 * 	@author AdminEWP
 */
@WebServlet("/ServiceController")
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ModelInterface<Service> model = new ServiceModelDS();
	private ServiceModelDS modelDs = (ServiceModelDS) model;

	/** 
	 *	Empty Constructor
	 */
    public ServiceController() {
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
		doPost(request,response);
	}

	/**
     *	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try{
			if(action == null){
				sendMessage("noAction", response);
				return;
			}else{
				
				// INSERT
				if (action.equalsIgnoreCase("insert")){
					String name 		= request.getParameter("name");
					String employee 	= request.getParameter("employee");
					String quantity 	= request.getParameter("quantity");
					String variation	= request.getParameter("variation");
					String note 		= request.getParameter("note");
					String receiptDate	= request.getParameter("recepitDate");
					String returnDate	= request.getParameter("returnDate");
					String aid 			= request.getParameter("aid");
					String cid 			= request.getParameter("");
					
					//control if empty
					if (
							name.equals("") 		||employee.equals("") 	|| quantity.equals("")		||
							variation.equals("") 	||	note.equals("") 	|| receiptDate.equals("") 	||
							returnDate.equals("") 	|| aid.equals("") 		|| cid.equals("")
						){
							sendMessage("empty", response);
							return;
					}
					
					//control if they respect the format
					if ( ! (
							Pattern.matches("[a-zA-Z]*", employee)	|| 
							Pattern.matches("[0-9]*", quantity) 	|| 
							Pattern.matches("[a-zA-Z]*", variation) || 
							Pattern.matches("[a-zA-Z]*", note) 		|| 
							Pattern.matches("(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)", receiptDate)	|| 
							Pattern.matches("(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)", returnDate) 	|| 
							Pattern.matches("[0-9]*", aid) || 
							Pattern.matches("[0-9]*", cid) || 
							Pattern.matches("[a-zA-Z]*", name)
							)
						){
								sendMessage("regExpError", response);
								return;
					}
					
					int  qt 	= Integer.parseInt(quantity);
					int  aID	= Integer.parseInt(aid);
					int	 cID 	= Integer.parseInt(cid);
					Date rec 	= Date.valueOf(receiptDate);
					Date ret	= Date.valueOf(returnDate);
					
					Service service = new Service(name, employee, qt, variation, note, rec, ret, aID, cID);
					LinkedList<Service> listService = modelDs.findAll();
					for (Service ser : listService) {
						if(ser.equals(service)){
							sendMessage("exist", response);
							return;
						}
					}
					
					try {
						modelDs.insert(service);
						sendMessage("insertOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}
				}
				
				// UPDATE
				if (action.equalsIgnoreCase("update")){
					
					int id = Integer.parseInt(request.getParameter("id"));
					Service oldService = modelDs.findByKey(id);
					if (oldService == null){
						sendMessage("noExist", response);
						return;
					}
					String name 		= request.getParameter("name");
					String employee 	= request.getParameter("employee");
					String quantity 	= request.getParameter("quantity");
					String variation 	= request.getParameter("variation");
					String note 		= request.getParameter("note");
					String receiptDate	= request.getParameter("recepitDate");
					String returnDate 	= request.getParameter("returnDate");
					String aid			= request.getParameter("aid");
					String cid 			= request.getParameter("");
					
					if(name.equals(""))
						name = oldService.getEmployee();
					
					if(employee.equals(""))
						employee = oldService.getEmployee();
					
					if(quantity.equals(""))
						quantity = String.valueOf(oldService.getQuantity());
					
					if(variation.equals(""))
						variation = oldService.getVariation();
					
					if(note.equals(""))
						note = oldService.getNote();
					
					if(receiptDate.equals(""))
						receiptDate = String.valueOf(oldService.getReceiptDate());
					
					if(returnDate.equals(""))
						returnDate = String.valueOf(oldService.getReturnDate());
					
					if(aid.equals(""))
						aid = String.valueOf(oldService.getArticleId());
					
					if(cid.equals(""))
						cid = String.valueOf(oldService.getCustomerId());
					
					//control if they respect the format
					if ( ! (Pattern.matches("[a-zA-Z]*", employee) || Pattern.matches("[0-9]*", quantity) || Pattern.matches("[a-zA-Z]*", variation) || 
							Pattern.matches("[a-zA-Z]*", note) || Pattern.matches("(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)", receiptDate) || Pattern.matches("(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)", returnDate) || 
							Pattern.matches("[0-9]*", aid) || Pattern.matches("[0-9]*", cid) || Pattern.matches("[a-zA-Z]*", name))){
								sendMessage("regExpError", response);
								return;
					}
					
					int qt = Integer.parseInt(quantity);
					int aID = Integer.parseInt(aid);
					int cID = Integer.parseInt(cid);
					Date rec = Date.valueOf(receiptDate);
					Date ret = Date.valueOf(returnDate);
					
					Service newService = new Service(name, employee, qt, variation, note, rec, ret, aID, cID);
					newService.setId(oldService.getId());
					try {
						modelDs.update(newService);
						sendMessage("updateOk", response);
						return;
					} catch (Exception e) {
						sendMessage("cError", response);
						return;
					}
					
				}
				
				// REMOVE
				if (action.equalsIgnoreCase("remove")){
					int id = Integer.parseInt(request.getParameter("id"));
					Service oldService = modelDs.findByKey(id);
					if (oldService == null){
						sendMessage("noExist", response);
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
				if (action.equalsIgnoreCase("search")){
					String attribute = request.getParameter("attribute");
					String toSearch = request.getParameter("toSearch");
					
					//control if empty
					if (attribute.equals("") && toSearch.equals("")){
						sendMessage("empty", response);
						return;
					}
					
					String regex = "";
					switch(attribute){
						case "employee":{regex = "[a-zA-Z]*";}break;
						case "articleId":{regex ="[0-9]*";}break;
						case "customerId":{regex = "[0-9]*";}break;
						case "receiptDate":{regex = "(0[1-9]|[12][0-9]|3[01])[-/]([0][0-9]|[1][012])[-/]([12]\\d\\d\\d)";}break;
					}
					
					if (!Pattern.matches(regex, toSearch)){
						sendMessage("regExpError", response);
						return;
					}
					
					LinkedList<Service> listService = modelDs.findByField(attribute, toSearch);
					
					if(listService.isEmpty()){
						sendMessage("emptyList", response);
						return;
					}else{
						request.setAttribute("servicesSearched", listService);
						sendMessage("listSearched", response);
						return;
					}
				}
				
				// VIEW LIST
				if (action.equalsIgnoreCase("viewList")){
					LinkedList<Service> listService = modelDs.findAll();
					
					if(listService.isEmpty()){
						sendMessage("emptyList", response);
						return;
					}else{
						request.setAttribute("service", listService);
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

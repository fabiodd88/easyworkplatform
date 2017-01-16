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
		ServiceModelDS custDb= new ServiceModelDS("dbtest");
		HttpSession session = request.getSession();
		try{
			if(action == null){
				sendMessage("noAction", response);
				return;
			}else{
				
				// INSERT
				if (action.equalsIgnoreCase("insert")){
					
					String name 		= request.getParameter("CodS");
					String customer		= request.getParameter("CustomerS");
					String quantity 	= request.getParameter("QuantityS");
					String variation 	= request.getParameter("VariationS");
					String note 		= request.getParameter("NoteS");
					String receiptDate	= request.getParameter("RecepitDateS");
					String returnDate 	= request.getParameter("ReturnDateS");
					String employee 	= request.getParameter("EmployeeS");
					String aid			= request.getParameter("AidS");
					

					
					int  qt 	= Integer.parseInt(quantity);
					int  aID	= Integer.parseInt(aid);
					int	 cID 	= Integer.parseInt(customer);
					Date rec 	= Date.valueOf(receiptDate);
					Date ret	= Date.valueOf(returnDate);
					
					Service service = new Service(employee, qt, variation, note, rec, ret, aID, cID);
					LinkedList<Service> listService = modelDs.findAll();
					
					if(listService != null){
						for (Service ser : listService) {
							if(ser.equals(service)){
								sendMessage("exist", response);
								return;
							}
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
					
					int id = Integer.parseInt(request.getParameter("modCodS"));
					Service oldService = modelDs.findByKey(id);
					
					if (oldService == null){
						sendMessage("noExist", response);
						return;
					}
					
					String name 		= request.getParameter("modCodS");
					String customer		= request.getParameter("modCustomerS");
					String quantity 	= request.getParameter("modQuantityS");
					String variation 	= request.getParameter("modVariationS");
					String note 		= request.getParameter("modNoteS");
					String receiptDate	= request.getParameter("modReceiptDateS");
					String returnDate 	= request.getParameter("modReturnDateS");
					String employee 	= request.getParameter("modEmployeeS");
					String aid			= request.getParameter("modAidS");
					
					int qt = Integer.parseInt(quantity);
					int aID = Integer.parseInt(aid);
					int cID = Integer.parseInt(customer);
					Date rec = Date.valueOf(receiptDate);
					Date ret = Date.valueOf(returnDate);
					
					Service newService = new Service(id,employee, qt, variation, note, rec, ret, aID, cID);
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
						session.setAttribute("services", listService);
						sendMessage("emptyList", response);
						return;
					}else{
						session.setAttribute("services", listService);
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

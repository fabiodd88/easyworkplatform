package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/*	Service 	
 *	Class that collects service information
*/
public class Service implements Cloneable {

	private int id;
	private String employee;
	private int quantity;
	private String variation;
	private String note;
	private Date receiptDate;
	private Date returnDate;
	private int articleId;
	private int customerId;

	// Empty constructor
	public Service() {}
	
	// Parametric constructor
	public Service(String employee, int quantity, String variation, String note, Date receiptdate, Date returnDate,
			int articleId, int customerId) {
		super();
		this.employee = employee;
		this.quantity = quantity;
		this.variation = variation;
		this.note = note;
		this.receiptDate = receiptdate;
		this.returnDate = returnDate;
		this.articleId = articleId;
		this.customerId = customerId;
	}

	// Get the employee
	public String getEmployee() {
		return employee;
	}

	// Set an employee
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	// Get the quantity
	public int getQuantity() {
		return quantity;
	}

	// Set a quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Get the variation
	public String getVariation() {
		return variation;
	}

	// Set a variation
	public void setVariation(String variation) {
		this.variation = variation;
	}

	// Get the note
	public String getNote() {
		return note;
	}

	// Set a note
	public void setNote(String note) {
		this.note = note;
	}

	// Get the receipt data
	public Date getReceiptDate() {
		return receiptDate;
	}

	// Set a receipt data
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	// Get the return data
	public Date getReturnDate() {
		return returnDate;
	}

	// Set a return date
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	// Get the article id
	public int getArticleId() {
		return articleId;
	}

	// Set an article id
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	// Get the customer id
	public int getCustomerId() {
		return customerId;
	}

	// Set a customer id
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// Get the id
	public int getId() {
		return id;
	}

	// Set an id
	public void setId(int id) {
		this.id = id;
	}

	// Return all the information in string format
	@Override
	public String toString() {
		return "Service [employee=" + employee + ", quantity=" + quantity + ", variation=" + variation + ", note="
				+ note + ", recepitDate=" + receiptDate + ", returnDate=" + returnDate + ", articleId=" + articleId
				+ ", customerId=" + customerId + "]";
	}

	// Compares 2 "service" object
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Service service = (Service) object;
		return 	(employee).equals(service.employee)	&&
				this.quantity == service.quantity	&&
				variation.equals(service.variation)	&&
				note.equals(service.note)			&&
				receiptDate.equals(service.receiptDate)	&&
				returnDate.equals(service.returnDate)	&&
				articleId	== service.articleId		&&
				customerId	== service.customerId;
				
	} 

	// Duplicate a service
	@Override
	public Service clone(){
		try{
			return (Service) super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}

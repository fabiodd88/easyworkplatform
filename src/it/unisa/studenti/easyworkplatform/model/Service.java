package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/**	
 * Class that collects service information
 * 
 * @author AdminEWP
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

	/**
	 * Empty constructor 
	 */
	public Service() {}
	
	/**
	 * Parametric constructor
	 * @param employee of the service
	 * @param quantity of the service
	 * @param variation of the service
	 * @param note of the service
	 * @param receiptdate of the service
	 * @param returnDate of the service
	 * @param articleId of the service
	 * @param customerId of the service
	 */
	public Service(String employee, int quantity, String variation, String note, Date receiptdate, Date returnDate,
			int articleId, int customerId) {
		super();
		this.id = 0;
		this.employee = employee;
		this.quantity = quantity;
		this.variation = variation;
		this.note = note;
		this.receiptDate = receiptdate;
		this.returnDate = returnDate;
		this.articleId = articleId;
		this.customerId = customerId;
	}

	/**
	 * Parametric constructor
	 * @param id of the service
	 * @param employee of the service
	 * @param quantity of the service
	 * @param variation of the service
	 * @param note of the service
	 * @param receiptdate of the service
	 * @param returnDate of the service
	 * @param articleId of the service
	 * @param customerId of the service
	 */
	public Service(int id, String employee, int quantity, String variation, String note, Date receiptdate, Date returnDate,
			int articleId, int customerId) {
		super();
		this.id = id;
		this.employee = employee;
		this.quantity = quantity;
		this.variation = variation;
		this.note = note;
		this.receiptDate = receiptdate;
		this.returnDate = returnDate;
		this.articleId = articleId;
		this.customerId = customerId;
	}



	/**
	 * Get the employee
	 * @return this employee
	 */
	public String getEmployee() {
		return employee;
	}

	/**
	 * Set an employee
	 * @param employee - Service employee
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	/**
	 * Get the quantity
	 * @return this quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set a quantity
	 * @param quantity - Service quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the variation
	 * @return this variation
	 */
	public String getVariation() {
		return variation;
	}

	/**
	 * Set a variation
	 * @param variation - Service variation
	 */
	public void setVariation(String variation) {
		this.variation = variation;
	}

	/**
	 * Get the note
	 * @return this note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Set a note
	 * @param note - Service note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Get the receipt date
	 * @return this receipt date
	 */
	public Date getReceiptDate() {
		return receiptDate;
	}

	/**
	 * Set a receipt date
	 * @param receiptDate - Service receipt date
	 */
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	/**
	 * Get the return date
	 * @return this return date
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * Set a return date
	 * @param returnDate - Service return date
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * Get the article id
	 * @return this article id
	 */
	public int getArticleId() {
		return articleId;
	}

	/**
	 * Set an article id
	 * @param articleId - Service Article id
	 */
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	/**
	 * Get the customer id
	 * @return this customer id
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Set a customer id
	 * @param customerId - Service Customer id
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Get the id
	 * @return this id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set an id
	 * @param id - Service id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** 
	 * Return all the information in string format
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return "Service [employee=" + employee + ", quantity=" + quantity + ", variation=" + variation + ", note="
				+ note + ", recepitDate=" + receiptDate + ", returnDate=" + returnDate + ", articleId=" + articleId
				+ ", customerId=" + customerId + "]";
	}

	/**
	 * Compares 2 "service" object
	 * @param object the reference object with which to compare
	 * @return true if this object is the same as the object argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Service service = (Service) object;
		return 	
				this.employee.equals(service.getEmployee())	&&
				this.quantity == service.getQuantity()	&&
				this.variation.equals(service.getVariation())	&&
				this.note.equals(service.getNote())			&&
				this.receiptDate.equals(service.getReceiptDate())	&&
				this.returnDate.equals(service.getReturnDate())	&&
				this.articleId	== service.getArticleId()		&&
				this.customerId	== service.getCustomerId();
				
	} 

	/**
	 * Duplicate a service
	 * @return a clone of this service.
	 */
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

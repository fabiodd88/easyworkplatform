package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/**	
 * 	Service 	
 *	Class that collects service information
 * 	@author AdminEWP
*/
public class Service implements Cloneable {

	private int id;
	private String employee;
	private int quantity;
	private String variation;
	private String note;
	private Date receiptDate;
	private Date returnDate;
	private String articleName;
	private String customerName;

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
			String articleName, String customerName) {
		super();
		this.employee = employee;
		this.quantity = quantity;
		this.variation = variation;
		this.note = note;
		this.receiptDate = receiptdate;
		this.returnDate = returnDate;
		this.articleName = articleName;
		this.customerName = customerName;
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
	 * @param employee
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
	 * @param quantity
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
	 * @param variation
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
	 * @param note
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
	 * @param receiptDate
	 */
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	/**
	 * Get the return date
	 * @return return date
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * Set a return date
	 * @param returnDate
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * Get the article name
	 * @return String
	 */
	public String getArticleName() {
		return articleName;
	}

	/**
	 * Set an article name
	 * @param articleName
	 */
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	/**
	 * Get the customer name
	 * @return String
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Set a customer name
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Return all the information in string format
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Service [employee=" + employee + ", quantity=" + quantity + ", variation=" + variation + ", note="
				+ note + ", recepitDate=" + receiptDate + ", returnDate=" + returnDate + ", articleName=" + articleName
				+ ", customerName=" + customerName + "]";

	}

	/**
	 * Compares 2 "service" object
	 * @see java.lang.Object#equals(java.lang.Object)
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
				this.articleName	== service.getArticleName()		&&
				this.customerName	== service.getCustomerName();
				
	} 

	/**
	 * Duplicate a service
	 * @see java.lang.Object#clone()
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

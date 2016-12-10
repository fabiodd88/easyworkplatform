package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class Service implements Cloneable {

	private String employee;
	private int quantity;
	private String variation;
	private String note;
	private Date recepitDate;
	private Date returnDate;
	private int articleId;
	private int customerId;

	
	public Service() {}
	
	
	public Service(String employee, int quantity, String variation, String note, Date recepitdate, Date returnDate,
			int articleId, int customerId) {
		super();
		this.employee = employee;
		this.quantity = quantity;
		this.variation = variation;
		this.note = note;
		this.recepitDate = recepitdate;
		this.returnDate = returnDate;
		this.articleId = articleId;
		this.customerId = customerId;
	}


	
	public String getEmployee() {
		return employee;
	}


	public void setEmployee(String employee) {
		this.employee = employee;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getVariation() {
		return variation;
	}


	public void setVariation(String variation) {
		this.variation = variation;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Date getRecepitDate() {
		return recepitDate;
	}


	public void setRecepitDate(Date recepitDate) {
		this.recepitDate = recepitDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public int getArticleId() {
		return articleId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	
	@Override
	public String toString() {
		return "Service [employee=" + employee + ", quantity=" + quantity + ", variation=" + variation + ", note="
				+ note + ", recepitDate=" + recepitDate + ", returnDate=" + returnDate + ", articleId=" + articleId
				+ ", customerId=" + customerId + "]";
	}


	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Service service = (Service) object;
		return 	(employee).equals(service.employee)	&&
				this.quantity == service.quantity	&&
				variation.equals(service.variation)	&&
				note.equals(service.note)			&&
				recepitDate.equals(service.recepitDate)	&&
				returnDate.equals(service.returnDate)	&&
				articleId	== service.articleId		&&
				customerId	== service.customerId;
				
	} 
	
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

package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class Service implements Cloneable {

	private String customer;
	private String itemIvolved;
	private Date date;
	private double amount;
	private String variations;
	private String employee;
	private Date returnDate;
	private String note;
	
	
	
	
	public Service(String customer, String itemIvolved, Date date, double amount, String variations, String employee,
			Date returnDate, String note) {
		super();
		this.customer = customer;
		this.itemIvolved = itemIvolved;
		this.date = date;
		this.amount = amount;
		this.variations = variations;
		this.employee = employee;
		this.returnDate = returnDate;
		this.note = note;
	}

	
	
	
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getItemIvolved() {
		return itemIvolved;
	}

	public void setItemIvolved(String itemIvolved) {
		this.itemIvolved = itemIvolved;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getVariations() {
		return variations;
	}

	public void setVariations(String variations) {
		this.variations = variations;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [customer=" + customer + ", itemIvolved=" + itemIvolved + ", amount=" + amount + ", variations="
				+ variations + ", employee=" + employee + ", note=" + note + "]";
	}
	
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Service service = (Service) object;
		return 	service.amount	== this.amount	&&
				service.customer== this.customer&&
				service.date	== this.date 	&&
				service.employee== this.employee&&
				service.itemIvolved ==  service.itemIvolved &&
				service.returnDate 	== this.returnDate &&
				service.variations 	== this.variations &&
				service.note == this.note;
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

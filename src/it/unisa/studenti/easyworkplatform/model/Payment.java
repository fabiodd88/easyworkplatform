package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class Payment implements Cloneable {

	private Date date;
	private String itemInvolved;
	private double amount;
	private String customer;

	
	public Payment(Date date, String itemInvolved, double amount, String customer) {	
		this.date = date;
		this.itemInvolved = itemInvolved;
		this.amount = amount;
		this.customer = customer;
	}

	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getItemInvolved() {
		return itemInvolved;
	}

	public void setItemInvolved(String itemInvolved) {
		this.itemInvolved = itemInvolved;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [date=" + date + ", itemInvolved=" + itemInvolved + ", amount=" + amount + ", customer="
				+ customer + "]";
	}
	
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() !=  this.getClass()) return false;
		Payment payment = (Payment) object;
		return 	payment.amount	== this.amount	&&
				payment.customer== this.customer&&
				payment.date	== this.date 	&&
				payment.itemInvolved == this.itemInvolved;
	} 
	
	
	@Override
	public Payment clone(){
		try{
			return (Payment) super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
}

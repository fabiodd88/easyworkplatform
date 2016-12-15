package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class Payment implements Cloneable {

	private int id;
	private Date date;
	private double amount;
	private int serviceCustomerId;
	private int serviceId;
	private int serviceArticleId;
	

	public Payment(){}
	
	public Payment(double amount, Date date, int serviceId , int serviceCustomerId, int serviceArticleId) {	
		this.date				= date;
		this.amount				= amount;
		this.serviceId			= serviceId;
		this.serviceCustomerId	= serviceCustomerId;
		this.serviceArticleId	= serviceArticleId;
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

	public int getServiceCustomerId() {
		return serviceCustomerId;
	}

	public void setServiceCustomerId(int serviceCustomerId) {
		this.serviceCustomerId = serviceCustomerId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getServiceArticleId() {
		return serviceArticleId;
	}

	public void setServiceArticleId(int serviceArticleId) {
		this.serviceArticleId = serviceArticleId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Payment [date=" + date + ", amount=" + amount + ", serviceCustomerId=" + serviceCustomerId
				+ ", serviceId=" + serviceId + ", serviceArticleId=" + serviceArticleId + "]";
	}

	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() !=  this.getClass()) return false;
		Payment payment = (Payment) object;
		return 	this.date.equals(payment.getDate())	&&
				this.amount == payment.amount		&&
				this.serviceId == payment.serviceId	&&
				this.serviceArticleId	== payment.serviceArticleId  &&
				this.serviceCustomerId	== payment.serviceCustomerId ;
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

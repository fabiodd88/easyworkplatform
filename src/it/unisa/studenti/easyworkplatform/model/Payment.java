package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/**
 * 	Payment 	
 *	Class that collects payment information
 *	@author AdminEWP
*/
public class Payment implements Cloneable {

	private int id;
	private Date date;
	private double amount;
	private int serviceCustomerId;
	private int serviceId;
	private int serviceArticleId;
	
	/**
	 * Empty constructor
	 */
	public Payment(){}
	
	/**
	 * Parametric constructor
	 * @param amount of the payment
	 * @param date of the payment
	 * @param serviceId of the payment
	 * @param serviceCustomerId of the payment
	 * @param serviceArticleId of the payment
	 */
	public Payment(double amount, Date date, int serviceId , int serviceCustomerId, int serviceArticleId) {	
		this.date				= date;
		this.amount				= amount;
		this.serviceId			= serviceId;
		this.serviceCustomerId	= serviceCustomerId;
		this.serviceArticleId	= serviceArticleId;
	}
		
	/**
	 * Get the date
	 * @return this date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set a date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Get the amount
	 * @return this amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Set an amount
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Get the service customer id
	 * @return this service customer id
	 */
	public int getServiceCustomerId() {
		return serviceCustomerId;
	}

	/**
	 * Set a service customer id
	 * @param serviceCustomerId
	 */
	public void setServiceCustomerId(int serviceCustomerId) {
		this.serviceCustomerId = serviceCustomerId;
	}
	
	/**
	 * Get the service id
	 * @return this service id
	 */
	public int getServiceId() {
		return serviceId;
	}

	/**
	 * Set a service id
	 * @param serviceId
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	/**
	 * Get the service article id
	 * @return this service article id
	 */
	public int getServiceArticleId() {
		return serviceArticleId;
	}

	/**
	 * Set a service article id
	 * @param serviceArticleId
	 */
	public void setServiceArticleId(int serviceArticleId) {
		this.serviceArticleId = serviceArticleId;
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
		return "Payment [date=" + date + ", amount=" + amount + ", serviceCustomerId=" + serviceCustomerId
				+ ", serviceId=" + serviceId + ", serviceArticleId=" + serviceArticleId + "]";
	}

	/**
	 * Compares 2 "payment" object
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
	
	/**
	 * Duplicate a payment
	 * @see java.lang.Object#clone()
	 */
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

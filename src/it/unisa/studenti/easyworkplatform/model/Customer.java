package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/**
 * Class that collects customer information
 * 
 * @author AdminEWP
*/
public class Customer implements Cloneable{
	private int id;
	private String name;
	private String surname;
	private Date birthdate;
	private String birthplace;
	private String address;
	private String city;
	private String province;
	private int cap;
	private int newsletter;
	private String phoneNumber;
	private String email;
	
	/**
	 * Empty constructor
	 */
	public Customer(){}
	
	
	/**
	 * Parametric constructor
	 * @param id of the customer
	 * @param name of the customer
	 * @param surname of the customer
	 * @param birthdate of the customer
	 * @param birthplace of the customer
	 * @param address of the customer
	 * @param city of the customer
	 * @param province of the customer
	 * @param cap of the customer
	 * @param newsletter of the customer
	 * @param phoneNumber of the customer
	 * @param email of the customer
	 */
	public Customer(int id, String name, String surname, Date birthdate, String birthplace, String address, String city,
			String province, int cap, int newsletter, String phoneNumber, String email) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.newsletter = newsletter;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
	
	
	/**
	 * Parametric constructor
	 * @param name of the customer
	 * @param surname of the customer
	 * @param birthdate of the customer
	 * @param birthplace of the customer
	 * @param address of the customer
	 * @param city of the customer
	 * @param province of the customer
	 * @param cap of the customer
	 * @param newsletter of the customer
	 * @param phoneNumber of the customer
	 * @param email of the customer
	 */
	public Customer(String name, String surname, Date birthdate, String birthplace, String address, String city,
			String province, int cap, int newsletter, String phoneNumber, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.newsletter = newsletter;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * Get the name
	 * @return this name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set a name
	 * @param name - Customer name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the surname
	 * @return this surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Set a surname
	 * @param surname - Customer surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Get the birthdate
	 * @return this birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Set a birthdate
	 * @param birthdate - Customer birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Get the birthplace
	 * @return this birthplace
	 */
	public String getBirthplace() {
		return birthplace;
	}

	/**
	 * Set a birthplace
	 * @param birthplace - Customer birthplace
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	/**
	 * Get the address
	 * @return this address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set an address
	 * @param address - Customer address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the city
	 * @return this city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set a city
	 * @param city - Customer city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the province
	 * @return this province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Set a province
	 * @param province - Customer province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Get the cap
	 * @return this cap
	 */
	public int getCap() {
		return cap;
	}

	/**
	 * Set a cap
	 * @param cap - Customer cap
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * Get the newsletter
	 * @return this newsletter
	 */
	public int getNewsletter() {
		return newsletter;
	}

	/**
	 * Set a newsletter
	 * @param newsletter - Customer newsletter
	 */
	public void setNewsletter(int newsletter) {
		this.newsletter = newsletter;
	}

	/**
	 * Get the phone number
	 * @return this phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set a phone number
	 * @param phoneNumber - Customer phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Get the email
	 * @return this email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set an email
	 * @param email - Customer email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @param id - Customer id
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
		return getClass().getSimpleName()+" [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", birthplace="
				+ birthplace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	/**
	 * Compares 2 "customer" object
	 * @param object the reference object with which to compare
	 * @return true if this object is the same as the object argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Customer customer = (Customer) object;
		return	this.name.equals(customer.getName())		&&
				this.surname.equals(customer.getSurname())		&&
				this.birthdate.equals(customer.getBirthdate())		&&
				this.birthplace.equals(customer.getBirthplace())		&&
				this.address.equals(customer.getAddress())		&&
				this.city.equals(customer.getCity())		&&
				this.province.equals(customer.getProvince())		&&
				this.cap == customer.getCap()		&&
				this.phoneNumber.equals(customer.getPhoneNumber())		&&
				this.email.equals(customer.getEmail());
	}
	
	/**
	 * Duplicate a customer
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Customer clone(){
		try{
			return (Customer) super.clone();
		}
		catch (CloneNotSupportedException  e) {
			return null;
		}
	}
	
}

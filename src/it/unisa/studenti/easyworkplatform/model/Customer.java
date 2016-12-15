package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/*	Customer 	
 *	Class that collects customer information
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
	private int newsletter;
	private int cap;
	private String phoneNumber;
	private String email;
	
	// Empty constructor
	public Customer(){}
	
	// Parametric constructor
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

	//Get the name
	public String getName() {
		return name;
	}

	// Set a name
	public void setName(String name) {
		this.name = name;
	}

	//Get the surname
	public String getSurname() {
		return surname;
	}

	// Set a surname
	public void setSurname(String surname) {
		this.surname = surname;
	}

	//Get the birthdate
	public Date getBirthdate() {
		return birthdate;
	}

	// Set a birthdate
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	//Get the birthplace
	public String getBirthplace() {
		return birthplace;
	}

	// Set a birthplace
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	//Get the address
	public String getAddress() {
		return address;
	}

	// Set an address
	public void setAddress(String address) {
		this.address = address;
	}

	//Get the city
	public String getCity() {
		return city;
	}

	// Set a city
	public void setCity(String city) {
		this.city = city;
	}

	//Get the province
	public String getProvince() {
		return province;
	}

	// Set a province
	public void setProvince(String province) {
		this.province = province;
	}

	//Get the cap
	public int getCap() {
		return cap;
	}

	// Set a cap
	public void setCap(int cap) {
		this.cap = cap;
	}

	//Get the newsletter
	public int getNewsletter() {
		return newsletter;
	}

	// Set a newsletter
	public void setNewsletter(int newsletter) {
		this.newsletter = newsletter;
	}

	//Get the phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}

	// Set a phone number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//Get the email
	public String getEmail() {
		return email;
	}

	// Set an email
	public void setEmail(String email) {
		this.email = email;
	}

	//Get the id	
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
		return getClass().getSimpleName()+" [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", birthplace="
				+ birthplace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	// Compares 2 "customer" object
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
	
	// Duplicate a customer
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

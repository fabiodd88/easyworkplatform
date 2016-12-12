package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

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
	
	public Customer(){}
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(int newsletter) {
		this.newsletter = newsletter;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", birthplace="
				+ birthplace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
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

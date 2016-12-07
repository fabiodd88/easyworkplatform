package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class Customer implements Cloneable{
	private String name;
	private String surename;
	private Date birthdate;
	private String birthplace;
	private String address;
	private String city;
	private String province;
	private int cap;
	private String phoneNumber;
	private String email;
	
	public Customer(){}
	
	public Customer(String name, String surename, Date birthdate, String birthplace, String address, String city,
			String province, int cap, String phoneNumber, String email) {
		super();
		this.name = name;
		this.surename = surename;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
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
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", surename=" + surename + ", birthdate=" + birthdate + ", birthplace="
				+ birthplace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Customer customer = (Customer) object;
		return	customer.address	== this.address 	&&
				customer.birthdate	== this.birthdate 	&&
				customer.birthplace == this.birthplace 	&&
				customer.phoneNumber== this.phoneNumber	&&
				customer.province 	== this.province	&&
				customer.cap	== this.cap 	&&
				customer.city	== this.city	&&
				customer.email	== this.address &&
				customer.name	== this.name	&&
				customer.surename== this.surename;
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

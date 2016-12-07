package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class User extends Account{
	
	private String name;
	private String surename;
	private Date birthdate;
	private String birthPlace;
	private String address;
	private String city;
	private int province;
	private int cap;
	private String taxCode;
	private String activity;
	
	public User() {}
	
	public User(String email,String password,String secondKey, String name, String surename, Date birthdate, String birthplace, String address, String city,
			int province, int cap, String taxCode, String activity) {
		super(email, password, secondKey);
		this.name = name;
		this.surename = surename;
		this.birthdate = birthdate;
		this.birthPlace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.taxCode = taxCode;
		this.activity = activity;
	}
	
	public User(Account account, String name, String surename, Date birthdate,
			String birthplace, String address, String city, int province, int cap, String taxCode, String activity) {
		super(account.getEmail(), account.getPassword(), account.getSecondKey());
		this.name = name;
		this.surename = surename;
		this.birthdate = birthdate;
		this.birthPlace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.taxCode = taxCode;
		this.activity = activity;
	}

	public User(String email, String password, String secondKey) {
		super(email, password, secondKey);
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
		return birthPlace;
	}

	public void setBirthplace(String birthplace) {
		this.birthPlace = birthplace;
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

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", surename=" + surename + ", birthdate=" + birthdate + ", burthplace="
				+ birthPlace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", taxCode=" + taxCode + ", activity=" + activity + "]";
	}
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		User user = (User) object;
		return	user.activity	== this.activity	&&
				user.address	== this.address		&&
				user.birthdate	== this.birthdate	&&
				user.birthPlace == this.birthPlace	&&
				user.taxCode	== this.taxCode 	&&
				user.province	== this.province	&&
				user.cap	== this.cap		&&
				user.city	== this.city	&&
				user.name	== this.name	&&
				user.surename == this.surename;
	}
	
	@Override
	public User clone(){
		try{
			return (User) super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	
}

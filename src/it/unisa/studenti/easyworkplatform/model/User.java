package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class User extends Account{
	
	private String name;
	private String surname;
	private Date birthdate;
	private String birthPlace;
	private String address;
	private String city;
	private String province;
	private int cap;
	private String taxCode;
	
	public User() {}
	
	public User(int id,String email,String password,String secondKey, String name, String surname, Date birthdate, String birthplace, String address, String city,
			String province, int cap, String taxCode) {
		super(id,email, password, secondKey);
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.birthPlace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.taxCode = taxCode;
	}
	
	public User(Account account, String name, String surname, Date birthdate,
			String birthplace, String address, String city, String province, int cap, String taxCode) {
		super(account.getEmail(), account.getPassword(), account.getSecondKey());
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.birthPlace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.taxCode = taxCode;
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
		return surname;
	}

	public void setSurename(String surname) {
		this.surname = surname;
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

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	
	@Override
	public String toString() {
		return super.toString() + getClass().getSimpleName()+" [name=" + name + ", surename=" + surname + ", birthdate=" + birthdate + ", burthplace="
				+ birthPlace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", taxCode=" + taxCode + "]";
	}
	
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		if(!super.equals(object)) return false; 
		User user = (User) object;
		return	this.name.equals(user.getName())			&& 
				this.surname.equals(user.getSurename())	&&
				this.birthdate.equals(user.getBirthdate())	&&
				this.birthPlace.equals(user.getBirthplace())&&
				this.address.equals(user.getAddress())		&&
				this.city.equals(user.getCity())			&&
				this.province.equals(user.getProvince())	&&
				this.cap == user.getCap()					&&
				this.taxCode.equals(user.getTaxCode());
	}
	
	
	@Override
	public User clone(){
		User user = (User) super.clone();
		user.name = name;
		user.city = city;
		user.cap  = cap;
		user.surname 	= surname;
		user.birthdate 	= birthdate;
		user.birthPlace = birthPlace;
		user.address	= address;
		user.province 	= province;
		user.taxCode 	= taxCode;
		return user;
	}
	
}

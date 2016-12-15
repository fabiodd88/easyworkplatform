package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/*	User 	
 *	Class that collects user information
*/
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
	
	// Empty constructor
	public User() {}
	
	// Parametric constructor
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

	// Get the name
	public String getName() {
		return name;
	}

	// Set a name
	public void setName(String name) {
		this.name = name;
	}

	// Get the surname
	public String getSurename() {
		return surname;
	}

	// Set a surname
	public void setSurename(String surname) {
		this.surname = surname;
	}

	// Get the birthdate
	public Date getBirthdate() {
		return birthdate;
	}

	// Set a birthdate
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	// Get the birthplace
	public String getBirthplace() {
		return birthPlace;
	}

	// Set a birthplace
	public void setBirthplace(String birthplace) {
		this.birthPlace = birthplace;
	}

	// Get the address
	public String getAddress() {
		return address;
	}

	// Set an address
	public void setAddress(String address) {
		this.address = address;
	}

	// Get the city
	public String getCity() {
		return city;
	}

	// Set a city
	public void setCity(String city) {
		this.city = city;
	}

	// Get the province
	public String getProvince() {
		return province;
	}

	// Set a province
	public void setProvince(String province) {
		this.province = province;
	}

	// Get the cap
	public int getCap() {
		return cap;
	}

	// Set a cap
	public void setCap(int cap) {
		this.cap = cap;
	}

	// Get the tax code
	public String getTaxCode() {
		return taxCode;
	}

	// Set a tax code
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	// Return all the information in string format
	@Override
	public String toString() {
		return super.toString() + getClass().getSimpleName()+" [name=" + name + ", surename=" + surname + ", birthdate=" + birthdate + ", burthplace="
				+ birthPlace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", taxCode=" + taxCode + "]";
	}
	
	// Compares 2 "user" object
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
	
	// Duplicate a user
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

package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

/*	User 	
 *	Class that collects user information
*/
public class User extends Account{
	
	private String name;
	private String surname;
	private Date birthdate;
	private String birthplace;
	private String address;
	private String city;
	private String province;
	private int cap;
	private String taxCode;
	
	/**
	 * Empty constructor
	 */
	public User() {}
	
	/**
	 * Parametric constructor
	 * @param account of the user
	 * @param name of the user
	 * @param surname of the user
	 * @param birthdate of the user
	 * @param birthplace of the user
	 * @param address of the user
	 * @param city of the user
	 * @param province of the user
	 * @param cap of the user
	 * @param taxCode of the user
	 */
	public User(Account account, String name, String surname, Date birthdate,
			String birthplace, String address, String city, String province, int cap, String taxCode) {
		super(account.getEmail(), account.getPassword(), account.getSecondKey());
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.taxCode = taxCode;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the surname
	 * @return
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Set a surname
	 * @param surname
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
	 * @param birthdate
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
	 * @param birthplace
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
	 * @param address
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
	 * @param city
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
	 * @param province
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
	 * @param cap
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * Get the tax code
	 * @return this tax code
	 */
	public String getTaxCode() {
		return taxCode;
	}

	/**
	 * Set a tax code
	 * @param taxCode
	 */
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	/**
	 * Return all the information in string format
	 * @see it.unisa.studenti.easyworkplatform.model.Account#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + getClass().getSimpleName()+" [name=" + name + ", surename=" + surname + ", birthdate=" + birthdate + ", burthplace="
				+ birthplace + ", address=" + address + ", city=" + city + ", province=" + province + ", cap=" + cap
				+ ", taxCode=" + taxCode + "]";
	}
	
	/**
	 * Compares 2 "user" object
	 * @see it.unisa.studenti.easyworkplatform.model.Account#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		if(!super.equals(object)) return false; 
		User user = (User) object;
		return	this.name.equals(user.getName())			&& 
				this.surname.equals(user.getSurname())	&&
				this.birthdate.equals(user.getBirthdate())	&&
				this.birthplace.equals(user.getBirthplace())&&
				this.address.equals(user.getAddress())		&&
				this.city.equals(user.getCity())			&&
				this.province.equals(user.getProvince())	&&
				this.cap == user.getCap()					&&
				this.taxCode.equals(user.getTaxCode());
	}
	
	/**
	 * Duplicate a user
	 * @see it.unisa.studenti.easyworkplatform.model.Account#clone()
	 */
	@Override
	public User clone(){
		User user = (User) super.clone();
		user.name = name;
		user.city = city;
		user.cap  = cap;
		user.surname 	= surname;
		user.birthdate 	= birthdate;
		user.birthplace = birthplace;
		user.address	= address;
		user.province 	= province;
		user.taxCode 	= taxCode;
		return user;
	}
	
}

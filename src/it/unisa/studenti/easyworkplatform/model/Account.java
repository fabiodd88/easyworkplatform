package it.unisa.studenti.easyworkplatform.model;

/** 	
 * Class that collects account information for authentication of a User
 * 
 * @author AdminEWP
*/
public class Account implements Cloneable{

	private int id;
	private String email;
	private String password;
	private String secondKey;
	
	/**
	 * 	Empty constructor
	 */
	public Account() {}
	
	/** Parametric constructor 
	 *
	 * 	@param email of this Account
	 * 	@param password of this Account
	 * 	@param secondKey of this Account
	 */
	public Account(String email, String password, String secondKey) {
		this.email = email;
		this.password = password;
		this.secondKey = secondKey;
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
	 * @param email - Account email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the password
	 * @return this password
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * Set a password
	 * @param password - Account password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the second key
	 * @return this second key
	 */
	public String getSecondKey() {
		return secondKey;
	}

	/**
	 * Set a second key
	 * @param secondKey - Account second key
	 */
	public void setSecondKey(String secondKey) {
		this.secondKey = secondKey;
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
	 * @param id  - Account id
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
		return getClass().getSimpleName()+"[id=" + id + ", email=" + email + ", password=" + password + ", secondKey=" + secondKey + "]";
	}

	/**
	 * Compares 2 "account" object 
	 * @param object the reference object with which to compare
	 * @return true if this object is the same as the object argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Account account = (Account) object;
		return	this.email.equals(account.getEmail()) 		&&
				this.password.equals(account.getPassword()) &&
				this.secondKey.equals(account.getSecondKey());
				
	}
	
	/**
	 * Duplicate an account
	 * @return a clone of this account.
	 */
	public Account clone(){
		try{
			return (Account)super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	
}

package it.unisa.studenti.easyworkplatform.model;

/*	Account 	
 *	Class that collects account information for authentication of a User
*/
public class Account implements Cloneable{

	private int id;
	private String email;
	private String password;
	private String secondKey;
	
	// Empty constructor 
	public Account() {}
	
	// Parametric constructor 
	public Account(String email, String password, String secondKey) {
		this.email = email;
		this.password = password;
		this.secondKey = secondKey;
	}

	// Get the email
	public String getEmail() {
		return email;
	}

	// Set an email
	public void setEmail(String email) {
		this.email = email;
	}

	// Get the password
	public String getPassword() {
		return password;
	}

	// Set a password
	public void setPassword(String password) {
		this.password = password;
	}

	// Get the second key
	public String getSecondKey() {
		return secondKey;
	}

	// Set a second key
	public void setSecondKey(String secondKey) {
		this.secondKey = secondKey;
	}

	// Get the id
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
		return getClass().getSimpleName()+"[id=" + id + ", email=" + email + ", password=" + password + ", secondKey=" + secondKey + "]";
	}

	// Compares 2 "account" object
	@Override
	public boolean equals(Object object) {
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Account account = (Account) object;
		return	this.email.equals(account.getEmail()) 		&&
				this.password.equals(account.getPassword()) &&
				this.secondKey.equals(account.getSecondKey());
				
	}
	
	// Duplicate an account
	public Account clone(){
		try{
			return (Account)super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	
}

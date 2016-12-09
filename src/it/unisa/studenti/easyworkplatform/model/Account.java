package it.unisa.studenti.easyworkplatform.model;

public class Account implements Cloneable{

	private int id;
	private String email;
	private String password;
	private String secondKey;
	
	public Account() {}
	
	
	
	
	public Account(int id, String email, String password, String secondKey) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.secondKey = secondKey;
	}


	public Account(String email, String password, String secondKey) {
		this.email = email;
		this.password = password;
		this.secondKey = secondKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecondKey() {
		return secondKey;
	}

	public void setSecondKey(String secondKey) {
		this.secondKey = secondKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+"[id=" + id + ", email=" + email + ", password=" + password + ", secondKey=" + secondKey + "]";
	}

	@Override
	public boolean equals(Object object) {
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Account account = (Account) object;
		return	this.email.equals(account.getEmail()) 		&&
				this.password.equals(account.getPassword()) &&
				this.secondKey.equals(account.getSecondKey());
				
	}
	
	public Account clone(){
		try{
			return (Account)super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	
}

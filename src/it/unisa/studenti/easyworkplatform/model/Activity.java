package it.unisa.studenti.easyworkplatform.model;

/*	Activity 	
 *	Class that collects activity information
*/
public class Activity implements Cloneable{
	
	private int id;
	private String vatNumber;
	private String name;
	private String type;
	private String address;
	private String city;
	private String province;
	private int cap;
	private int userId;
	
	// Empty constructor
	public Activity() {}
	
	// Parametric constructor
	public Activity(String name, String type, String address, String city, String province, int cap, String vatNumber, int userId) {
		this.name = name;
		this.type = type;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.vatNumber = vatNumber;
		this.userId = userId;
	}
	
	// Get the name
	public String getName() {
		return name;
	}

	// Set a name
	public void setName(String name) {
		this.name = name;
	}

	// Get the type
	public String getType() {
		return type;
	}

	// Set a type
	public void setType(String type) {
		this.type = type;
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

	// Get the vat number
	public String getVatNumber() {
		return vatNumber;
	}

	// Set a vat number
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	// Get the id
	public int getId() {
		return id;
	}

	// Set an id
	public void setId(int id) {
		this.id = id;
	}

	// Get the user id
	public int getUserId() {
		return userId;
	}

	// Set an user id
	public void setUserId(int userId) {
		this.userId = userId;
	}

	// Return all the information in string format
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", type=" + type + ", address=" + address + ", city=" + city + ", province="
				+ province + ", cap=" + cap + ", vatNumber=" + vatNumber + "]";
	}
	
	// Compares 2 "activity" object
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Activity activity = (Activity) object;
		return 	this.address.equals(activity.getAddress())		&& 
				this.province.equals(activity.getProvince())	&&
				this.vatNumber.equals(activity.getVatNumber())	&&
				this.cap == activity.getCap()					&&
				this.city.equals(activity.getCity())			&& 
				this.name.equals(activity.getName())			&&
				this.type.equals(activity.getType())			&&
				this.userId == activity.getUserId();
	}
	
	// Duplicate an activity
	@Override
	public Article clone(){
		try{
			return (Article) super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	
}

package it.unisa.studenti.easyworkplatform.model;

/**
 * Class that collects activity information
 * 
 * @author AdminEWP
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
	
	/**
	 * Empty constructor 
	 */
	public Activity() {}
	
	/**
	 * Parametric constructor
	 * @param name of the activity
	 * @param type of the activity
	 * @param address of the activity
	 * @param city of the activity
	 * @param province of the activity
	 * @param cap of the activity
	 * @param vatNumber of the activity
	 * @param userId of the activity
	 */
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
	
	/**
	 * Get the name
	 * @return this name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set a name
	 * @param name - Activity name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the type
	 * @return this type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set a type
	 * @param type - Activity type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @param address - Activity address
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
	 * @param city - Activity city
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
	 * @param province - Activity province
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
	 * @param cap - Activity cap
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * Get the vat number
	 * @return this vat number
	 */
	public String getVatNumber() {
		return vatNumber;
	}

	/**
	 * Set a vat number
	 * @param vatNumber  - Activity vat number
	 */
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
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
	 * @param id - Activity id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the user id
	 * @return this user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Set an user id
	 * @param userId - Activity User id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/** 
	 * Return all the information in string format
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", type=" + type + ", address=" + address + ", city=" + city + ", province="
				+ province + ", cap=" + cap + ", vatNumber=" + vatNumber + "]";
	}
	
	/**
	 * Compares 2 "activity" object
	 * @param object the reference object with which to compare
	 * @return true if this object is the same as the object argument; false otherwise.
	 */
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
	
	/**
	 * Duplicate an activity
	 * @return a clone of this activity.
	 */
	@Override
	public Activity clone(){
		try{
			return (Activity) super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	
}

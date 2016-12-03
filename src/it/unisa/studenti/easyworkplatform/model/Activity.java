package it.unisa.studenti.easyworkplatform.model;

public class Activity implements Cloneable{
	private String name;
	private String type;
	private String address;
	private String city;
	private String province;
	private int cap;
	private String vatNumber;
	
	
	public Activity(String name, String type, String address, String city, String province, int cap, String vatNumber) {
		this.name = name;
		this.type = type;
		this.address = address;
		this.city = city;
		this.province = province;
		this.cap = cap;
		this.vatNumber = vatNumber;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}


	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", type=" + type + ", address=" + address + ", city=" + city + ", province="
				+ province + ", cap=" + cap + ", vatNumber=" + vatNumber + "]";
	}
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Activity activity = (Activity) object;
		return 	activity.address	== this.address		&& 
				activity.province	== this.province	&&
				activity.vatNumber	== this.vatNumber	&&
				activity.cap 	== this.cap		&&
				activity.city 	== this.city	&& 
				activity.name	== this.name	&&
				activity.type 	== this.type;
	}
	
	
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
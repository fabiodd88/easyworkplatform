package it.unisa.studenti.easyworkplatform.model;

public class Newsletter implements Cloneable {

	private String sender;
	private String reciver;
	private String object;
	private String message;
	
	public Newsletter(){}
	
	public Newsletter(String sender, String reciver, String object, String message) {
		super();
		this.sender = sender;
		this.reciver = reciver;
		this.object = object;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return getClass().getSimpleName()+" [sender=" + sender + ", reciver=" + reciver + ", object=" + object + ", message=" + message
				+ "]";
	}
	
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Newsletter newsletter = (Newsletter) object;
		return  newsletter.message	== this.message &&
				newsletter.reciver	== this.reciver &&
				newsletter.object	== this.object	&&
				newsletter.sender	== this.sender;
	}
	
	
	@Override
	public Newsletter clone(){
		try{
			return  (Newsletter) super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	
}

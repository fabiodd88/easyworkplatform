package it.unisa.studenti.easyworkplatform.model;

public class Newsletter implements Cloneable {

	private String sender;
	private String receiver;
	private String object;
	private String message;
	
	public Newsletter(){}
	
	public Newsletter(String sender, String receiver, String object, String message) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.object = object;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
		return getClass().getSimpleName()+" [sender=" + sender + ", receiver=" + receiver + ", object=" + object + ", message=" + message
				+ "]";
	}
	
	
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Newsletter newsletter = (Newsletter) object;
		return  this.message.equals(newsletter.getMessage()) &&
				this.receiver.equals(newsletter.getReceiver()) &&
				this.object.equals(newsletter.getObject())	&&
				this.sender.equals(newsletter.getSender());
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

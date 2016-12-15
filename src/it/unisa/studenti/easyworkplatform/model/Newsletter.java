package it.unisa.studenti.easyworkplatform.model;

/*	Newsletter
 *	Class that collects newsletter information
*/
public class Newsletter implements Cloneable {

	private String sender;
	private String receiver;
	private String object;
	private String message;

	// Empty constructor
	public Newsletter(){}
	
	// Parametric constructor
	public Newsletter(String sender, String receiver, String object, String message) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.object = object;
		this.message = message;
	}

	//Get the sender
	public String getSender() {
		return sender;
	}

	//Set a sender
	public void setSender(String sender) {
		this.sender = sender;
	}

	//Get the receiver
	public String getReceiver() {
		return receiver;
	}

	//Set a receiver
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	//Get the object
	public String getObject() {
		return object;
	}

	//Set an object
	public void setObject(String object) {
		this.object = object;
	}

	//Get the message
	public String getMessage() {
		return message;
	}

	//Set a message
	public void setMessage(String message) {
		this.message = message;
	}

	// Return all teh information in string format
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [sender=" + sender + ", receiver=" + receiver + ", object=" + object + ", message=" + message
				+ "]";
	}
	
	// Compares 2 "newsletter" object
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
	
	// Duplicate a newsletter
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

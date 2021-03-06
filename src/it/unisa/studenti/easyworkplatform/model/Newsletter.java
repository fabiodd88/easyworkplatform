package it.unisa.studenti.easyworkplatform.model;

/**	
 * Class that collects newsletter information
 * 
 * @author AdminEWP
*/
public class Newsletter implements Cloneable {

	private String sender;
	private String receiver;
	private String object;
	private String message;

	/**
	 * Empty constructor
	 */
	public Newsletter(){}
	
	/**
	 * Parametric constructor
	 * @param sender of the newsletter
	 * @param receiver of the newsletter
	 * @param object of the newsletter
	 * @param message of the newsletter
	 */
	public Newsletter(String sender, String receiver, String object, String message) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.object = object;
		this.message = message;
	}

	/**
	 * Get the sender
	 * @return this sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Set a sender
	 * @param sender - Newsletter sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * Get the receiver
	 * @return this receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * Set a receiver
	 * @param receiver - Newsletter receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Get the object
	 * @return this object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * Set an object
	 * @param object - Newsletter object
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * Get the message
	 * @return this message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set a message
	 * @param message - Newsletter message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** 
	 * Return all the information in string format
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [sender=" + sender + ", receiver=" + receiver + ", object=" + object + ", message=" + message
				+ "]";
	}
	
	/**
	 * Compares 2 "newsletter" object
	 * @param object the reference object with which to compare
	 * @return true if this object is the same as the object argument; false otherwise.
	 */
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
	
	/**
	 * Duplicate a newsletter
	 * @return a clone of this newsletter.
	 */
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

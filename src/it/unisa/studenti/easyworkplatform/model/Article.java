package it.unisa.studenti.easyworkplatform.model;

/**
 * Class that collects article information
 * 
 * @author AdminEWP
*/
public class Article implements Cloneable{
	private int id;
	private String name;
	private double price;
	private String description;
	private int duration;
	
	/**
	 * Empty constructor
	 */
	public Article(){}
	
	/**
	 * Parametric constructor
	 * @param name of the article
	 * @param price of the article
	 * @param description of the article
	 * @param duration of the article
	 */
	public Article(String name, double price, String description, int duration){
		this.name = name;
		this.price = price;
		this.description= description;
		this.duration = duration;
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
	 * @param name - Article name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the price
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set a price
	 * @param price - Article price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Get the description
	 * @return this description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set a description
	 * @param description - Article description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Get the duration
	 * @return this duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Set a duration
	 * @param duration - Article duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
	 * @param id - Article id
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
		return getClass().getSimpleName()+" [name=" + name + ", price=" + price + ", description=" + description + ", duration=" + duration
				+ "]";
	}
	
	/**
	 * Compares 2 "article" object
	 * @param object the reference object with which to compare
	 * @return true if this object is the same as the object argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;
		Article article = (Article) object;
		return	this.description.equals(article.getDescription())	&& 
				this.duration == article.getDuration()		 		&&
				this.name.equals(article.getName())					&& 
				this.price == article.price;
	}
	
	/**
	 * Duplicate an article
	 * @return a clone of this article.
	 */
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

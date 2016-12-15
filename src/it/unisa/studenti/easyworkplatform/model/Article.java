package it.unisa.studenti.easyworkplatform.model;

/*	Article 	
 *	Class that collects article information
*/
public class Article implements Cloneable{
	private int id;
	private String name;
	private double price;
	private String description;
	private int duration;
	
	// Empty constructor
	public Article(){}
	
	// Parametric constructor
	public Article(String name, double price, String description, int duration){
		this.name = name;
		this.price = price;
		this.description= description;
		this.duration = duration;
	}
	
	// Get the name
	public String getName() {
		return name;
	}

	//Set a 
	public void setName(String name) {
		this.name = name;
	}
	
	// Get the price
	public double getPrice() {
		return price;
	}

	//Set a price
	public void setPrice(double price) {
		this.price = price;
	}
	
	// Get the description
	public String getDescription() {
		return description;
	}

	//Set a description
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Get the duration
	public int getDuration() {
		return duration;
	}

	//Set a duration
	public void setDuration(int duration) {
		this.duration = duration;
	} 
	
	// Get the id
	public int getId() {
		return id;
	}

	//Set an id
	public void setId(int id) {
		this.id = id;
	}

	// Return all the information in string format
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", price=" + price + ", description=" + description + ", duration=" + duration
				+ "]";
	}
	
	// Compares 2 "article" object
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
	
	// Duplicate an article
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

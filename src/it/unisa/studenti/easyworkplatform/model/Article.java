package it.unisa.studenti.easyworkplatform.model;

public class Article implements Cloneable{
	private int idArticle;
	private String name;
	private double price;
	private String description;
	private int duration;
	
	public Article(){}
	
	public Article(String name, double price, String description, int duration){
		this.name = name;
		this.price = price;
		this.description= description;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	} 
	
	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" [name=" + name + ", price=" + price + ", description=" + description + ", duration=" + duration
				+ "]";
	}
	
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

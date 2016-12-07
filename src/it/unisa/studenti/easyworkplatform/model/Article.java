package it.unisa.studenti.easyworkplatform.model;

import java.util.Date;

public class Article implements Cloneable{
	private String name;
	private double price;
	private String description;
	private Date duration;
	
	public Article(){}
	
	public Article(String name, double price, String description, Date duration){
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

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
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
		return	article.description == this.description	&& 
				article.duration== this.duration &&
				article.name	== this.name && 
				article.price	== this.price;
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

package com.practice.domain;

public class Food {
	private Integer id;
	private String name;
	private String flavor;
	private String photo;
	private Float price;
	private String descrip;
	
	
	public Food() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", flavor=" + flavor + ", photo=" + photo + ", price=" + price
				+ ", descrip=" + descrip + "]";
	}
	
	
}

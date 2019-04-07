package com.practice.domain;

public class Food {
	private String id;
	private String foodName;
	private String taste;
	private String foodImage;
	private String price;
	private String description;
	
	
	public Food() {
		super();
	}

	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}

	
	public String getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", 菜名=" + foodName + ", 口味=" + taste + ", 图片=" + foodImage
				+ ", 价格=" + price + ", 描述=" + description + "]";
	}

	
}

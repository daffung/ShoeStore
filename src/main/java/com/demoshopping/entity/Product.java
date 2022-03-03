package com.demoshopping.entity;


import java.sql.Timestamp;

public class Product {
	private long pID;
	private String name;
	private String image;
	private String price;
	private String title;
	private String description;
	private int cateID;
	private int sellID;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	
	
	

	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public long getpID() {
		return pID;
	}
	public void setpID(long pID) {
		this.pID = pID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public int getSellID() {
		return sellID;
	}
	public void setSellID(int sellID) {
		this.sellID = sellID;
	}
	@Override
	public String toString() {
		return "Product [pID=" + pID + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title
				+ ", description=" + description + ", cateID=" + cateID + ", sellID=" + sellID + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
}

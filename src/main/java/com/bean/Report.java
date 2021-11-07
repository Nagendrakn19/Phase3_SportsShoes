package com.bean;



import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Report {
	@Id
	private int id;
	private String productname;
	private int price;
	private String buyer;
	private String category;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", productname=" + productname + ", price=" + price + ", buyer=" + buyer
				+ ", category=" + category + ", date=" + date + "]";
	}
	

	
	
	
	
	
	

}

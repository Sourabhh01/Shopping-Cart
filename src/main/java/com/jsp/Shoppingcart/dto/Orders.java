package com.jsp.Shoppingcart.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    private long mobilenum;
    
    private String address;
    private double totalPrice;
    
    @OneToMany
    private List<Item> items;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(long mobilenum) {
		this.mobilenum = mobilenum;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
    
    
}

package com.jsp.Shoppingcart.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Customer {
	
	
    private String name;
    private String address;
    @Column(unique = true)
    private long mobilenum;
    
    @Id
    private String email;
    
    private String password;
    
    @OneToOne
    private Cart cart;
    
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Orders> orders;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(long mobilenum) {
		this.mobilenum = mobilenum;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
    
    
    
}

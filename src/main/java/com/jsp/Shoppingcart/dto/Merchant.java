package com.jsp.Shoppingcart.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {
    private String name;
    
    @Column(unique = true)
    private long mobilenum;
    
    
    @Id
    private String email;
    
    private String password;
    
    @OneToMany
    private List<Product> products;

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

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
}

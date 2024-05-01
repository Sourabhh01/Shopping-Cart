package com.jsp.Shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.border.EtchedBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Shoppingcart.dto.Merchant;
import com.jsp.Shoppingcart.dto.Product;


@Repository
public class MerchantDao {
	@Autowired
	EntityManagerFactory emf;
	

	public void saveMerchant(Merchant merchant) {
	EntityManager em = emf.createEntityManager();
	EntityTransaction et =  em.getTransaction();
	et.begin();
	em.persist(merchant);
	et.commit();
	}
	
	public Merchant login(String email,String password) {
		EntityManager em = emf.createEntityManager();
		Merchant merchant = em.find(Merchant.class, email);
		return (merchant != null && merchant.getPassword().equals(password))? merchant :null;
	}
	
	public void deleteMerchant(String email) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Merchant.class, email));
		em.getTransaction().commit();
	}
	
	public void updateMerchant(Merchant merchant) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(merchant);
		em.getTransaction().commit();
	}
	
	public Merchant findMerchant(String email) {
		return emf.createEntityManager().find(Merchant.class, email);
	}
	public Merchant deleteProductFromMerchant(String m_email,int p_id) {
		EntityManager em = emf.createEntityManager();
		
		
		Merchant m  = em.find(Merchant.class, m_email);
		List<Product> products = m.getProducts();
		List<Product> productList = new ArrayList<Product>();
		for(Product p : products) {
			if(p.getId() != p_id) productList.add(p);
		}
		m.setProducts(productList);
		return m;
//		products.stream().filter(product->product.getId()!=products_id).collect(Collectors.toList());
	}
}

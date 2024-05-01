package com.jsp.Shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Shoppingcart.dto.Cart;

@Repository
public class CartDao {

	@Autowired
	EntityManagerFactory emf;
	public void saveCart(Cart cart) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =  em.getTransaction();
		et.begin();
		em.persist(cart);
		et.commit();
	}
	
	public void updateCart(Cart cart) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(cart);
		em.getTransaction().commit();
	}
	
	public void deletebyid(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Cart.class, id));
		em.getTransaction().commit();
	}
	
	public Cart findbyid(int id) {
		return emf.createEntityManager().find(Cart.class, id);	
	}
	
	public void removeAllItemFromCart(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =  em.getTransaction();
		
		Cart c = em.find(Cart.class, id);
		c.setItems(null);
		c.setTotalPrice(0);
		
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public void removeItemFromcartByid(int cart_id,int item_id) {
		
	}
}

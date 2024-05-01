package com.jsp.Shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Shoppingcart.dto.Cart;
import com.jsp.Shoppingcart.dto.Item;

@Repository
public class ItemDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveItem(Item item) { 
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =  em.getTransaction();
		et.begin();
		em.persist(item);
		et.commit();
	}
	public void updateItem(Item item) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(item);
		em.getTransaction().commit();
	}
	public void deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Cart.class, id));
		em.getTransaction().commit();
	}
	public Item findItem(int id ) {
		return  emf.createEntityManager().find(Item.class, id);
	}
}

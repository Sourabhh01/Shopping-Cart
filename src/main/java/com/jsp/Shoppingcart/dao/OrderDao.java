package com.jsp.Shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Shoppingcart.dto.Cart;
import com.jsp.Shoppingcart.dto.Orders;

@Repository
public class OrderDao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveOrder(Orders order) { 
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =  em.getTransaction();
		et.begin();
		em.persist(order);
		et.commit();
	}
	public void updateOrder(Orders order) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(order);
		em.getTransaction().commit();	
	}
	public void deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Orders.class, id));
		em.getTransaction().commit();
	}
	public Orders findOrdersbyid(int id ) {
		return  emf.createEntityManager().find(Orders.class, id);
	}
}

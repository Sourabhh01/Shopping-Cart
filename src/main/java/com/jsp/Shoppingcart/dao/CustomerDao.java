package com.jsp.Shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Shoppingcart.dto.Customer;

@Repository
public class CustomerDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveCustomer(Customer customer) {
	EntityManager em = emf.createEntityManager();
	EntityTransaction et =  em.getTransaction();
	et.begin();
	em.persist(customer);
	et.commit();
	}
	
	public Customer login(String email,String password) {
		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, email);
		if(customer.getPassword().equals(password)) return customer;
		else return null;
	}
	
	
	public void deleteCustomer(String email) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Customer.class, email));
		em.getTransaction().commit();
	}
	
	public void updateCustomer(Customer customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}
	
	public Customer findCustomer(String email) {
		EntityManager em = emf.createEntityManager();
		return em.find(Customer.class, email);
	}
}

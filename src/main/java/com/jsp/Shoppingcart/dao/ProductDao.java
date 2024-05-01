package com.jsp.Shoppingcart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Shoppingcart.dto.Cart;
import com.jsp.Shoppingcart.dto.Product;

@Repository
public class ProductDao {
	@Autowired
	EntityManagerFactory emf;
	public void saveProduct(Product product) { 
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =  em.getTransaction();
		et.begin();
		em.persist(product);
		et.commit();
	}
	public void updateProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();	
	}
	public void deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Product.class, id));
		em.getTransaction().commit();
	}
	public Product findProductbyid(int id ) {
		return  emf.createEntityManager().find(Product.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAllProduct(){
		return emf.createEntityManager().createQuery("Select p from Product p").getResultList();
		//getresult is a method present in QUery interface it will fetch result in the form of list
		//getSingleresult is to fetch single result
	}
	public List<Product> findproductbybrand(String brand){
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p from Product p where p.brand=?1");
		q.setParameter(1,brand);
		return q.getResultList();
	}
	public List<Product> findproductbyCategory(String category){
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p from Product p where p.category=?1");
		q.setParameter(1,category);
		return q.getResultList();
	}
	public List<Product> findproductbymodel(String model){
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p from Product p where p.model=?1");
		q.setParameter(1,model);
		return q.getResultList();
	}
}

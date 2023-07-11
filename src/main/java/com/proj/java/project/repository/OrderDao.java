package com.proj.java.project.repository;

import org.aspectj.weaver.ast.Or;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proj.java.project.entity.Order;
import com.proj.java.project.entity.User;

import jakarta.persistence.EntityManager;

@Repository
public class OrderDao {
 
    private EntityManager entityManager;
    
	@Autowired
	public OrderDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	


	public Order getOrder(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Order o = currentSession.get(Order.class, id);
		currentSession.close();
		return o;
	}
	

	@Transactional
	public void addOrder(final Order order) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(order);
		currentSession.close();
	}

	@Transactional
	public void deleteOrder(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Order order = currentSession.get(Order.class, id);
		currentSession.remove(order);
		currentSession.close();
	
	}
    	
}

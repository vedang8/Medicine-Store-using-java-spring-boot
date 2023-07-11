package com.proj.java.project.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proj.java.project.entity.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AdminDao {
    
	private EntityManager entityManager;

	@Autowired
	public AdminDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	public boolean validate(String email,String password) {
		Session currentSession = entityManager.unwrap(Session.class);
		if (email.equals("ayush") && password.equals("vedang")) {
			return true;
		}
		return false;
	}
	

}

package com.proj.java.project.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proj.java.project.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDao {

	private EntityManager entityManager;
    
	@Autowired
	public UserDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public User getUser(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User u = currentSession.get(User.class, id);
		currentSession.close();
		return u;
	}
	
	
	@SuppressWarnings("finally")
	public User validate (String email,String password){
		Session currentSession = entityManager.unwrap(Session.class);
		User u = null ;
		try {
		u= entityManager.createQuery("SELECT u FROM User u WHERE u.username = :email AND u.password = :password", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
		}
		finally {
		if(u == null)return null;
		else
		return u;
		}
	}	

	
	public List<User> getUsers() {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<User> theQuery = currentSession.createQuery("from User", User.class);
		List<User> users = theQuery.getResultList();
		currentSession.close();
		return users;
	}
	@Transactional
	public void addUser(final User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(user);
		currentSession.close();
	}
//
	@Transactional
	public void updateUser(final User u) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(u);
		currentSession.close();
	}
//
	@Transactional
	public void deleteUser(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User u = currentSession.get(User.class, id);
		currentSession.remove(u);
		currentSession.close();

	}
	
}

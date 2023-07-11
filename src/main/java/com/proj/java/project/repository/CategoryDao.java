package com.proj.java.project.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proj.java.project.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CategoryDao {
	
	@Autowired
	private EntityManager entityManager;
	
	
	
	public CategoryDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	
	}
	
	public List<Category> getcategories() {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<Category> theQuery = currentSession.createQuery("from Category", Category.class);
		List<Category> categories = theQuery.getResultList();
		currentSession.close();
		return categories;
	}
	
//
	@Transactional
	public void updateCategory(final Category c) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(c);
		currentSession.close();
	}
//
	@Transactional
	public void deleteCategory(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Category c = currentSession.get(Category.class, id);
		currentSession.remove(c);
		currentSession.close();

	}

	public Category getCategory(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Category cd = currentSession.get(Category.class, id);
		currentSession.close();
		return cd;
	}

	public void addCate(Category cd) {
	
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(cd);
		currentSession.close();
	}

	
	
}

package com.proj.java.project.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.proj.java.project.entity.Medicine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class MedicineDao {

	private EntityManager entityManager;

	@Autowired
	public MedicineDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Medicine getMedicine(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Medicine m = currentSession.get(Medicine.class, id);
		currentSession.close();
		return m;
	}

	public List<Medicine> getMedicines() {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<Medicine> theQuery =
				currentSession.createQuery("from Medicine", Medicine.class);
		List<Medicine> medicines = theQuery.getResultList();

		currentSession.close();
		return medicines;
	}
	@Transactional
	public void addMedicine(final Medicine m) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(m);
		currentSession.close();
	}

	@Transactional
	public void updateMedicine(final Medicine m) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(m);
		currentSession.close();
	}

	@Transactional
	public void deleteMedicine(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Medicine m = currentSession.get(Medicine.class, id);
		currentSession.remove(m);
		currentSession.close();
				
	}

}

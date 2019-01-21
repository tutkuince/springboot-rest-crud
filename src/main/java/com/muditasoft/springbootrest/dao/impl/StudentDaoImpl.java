package com.muditasoft.springbootrest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muditasoft.springbootrest.dao.StudentDao;
import com.muditasoft.springbootrest.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	// Define field for entitymanager
	private EntityManager entityManager;
	
	
	// set up constructor injection
	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Student> findAll() {
		// Get the current hibernate session
		// unwrap -> Get current Hibernate Session
		Session session = entityManager.unwrap(Session.class);
		
		// Create Query
		Query<Student> query = session.createQuery("from Student", Student.class);
		
		// Execute query and get result list
		List<Student> studentList = query.getResultList();
		
		// return the results
		return studentList;
	}


	@Override
	public Student findById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Student.class, id);
	}


	
}

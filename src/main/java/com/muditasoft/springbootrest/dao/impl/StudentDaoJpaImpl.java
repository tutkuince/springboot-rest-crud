package com.muditasoft.springbootrest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muditasoft.springbootrest.dao.StudentDao;
import com.muditasoft.springbootrest.model.Student;

@Repository
public class StudentDaoJpaImpl implements StudentDao {

	private EntityManager entityManager;

	@Autowired
	public StudentDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		// Create a Query
		Query query = entityManager.createQuery("from Student");
		
		// Execute query and get result list
		List<Student> studentList = query.getResultList();
		
		// return the results
		return studentList;
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

}

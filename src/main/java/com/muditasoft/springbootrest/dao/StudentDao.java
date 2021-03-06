package com.muditasoft.springbootrest.dao;

import java.util.List;

import com.muditasoft.springbootrest.model.Student;

public interface StudentDao {
	List<Student> findAll();
	Student findById(Long id);
	void saveOrUpdate(Student student);
	void deleteById(Long id);
}

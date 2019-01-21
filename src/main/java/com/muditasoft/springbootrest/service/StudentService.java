package com.muditasoft.springbootrest.service;

import java.util.List;

import com.muditasoft.springbootrest.model.Student;

public interface StudentService {
	List<Student> findAll();
	Student findById(Long id);
	void saveOrUpdate(Student student);
	void deleteById(Long id);
}

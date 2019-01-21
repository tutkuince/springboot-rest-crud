package com.muditasoft.springbootrest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muditasoft.springbootrest.dao.StudentDao;
import com.muditasoft.springbootrest.model.Student;
import com.muditasoft.springbootrest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDao.findAll();
	}
}
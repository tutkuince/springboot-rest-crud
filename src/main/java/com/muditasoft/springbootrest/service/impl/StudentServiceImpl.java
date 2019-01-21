package com.muditasoft.springbootrest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.muditasoft.springbootrest.dao.StudentDao;
import com.muditasoft.springbootrest.model.Student;
import com.muditasoft.springbootrest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(@Qualifier("studentDaoJpaImpl")StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDao.findAll();
	}
	
	@Override
	@Transactional
	public Student findById(Long id) {
		return studentDao.findById(id);
	}



	@Override
	@Transactional
	public void saveOrUpdate(Student student) {
		studentDao.saveOrUpdate(student);
	}



	@Override
	@Transactional
	public void deleteById(Long id) {
		studentDao.deleteById(id);
	}
}

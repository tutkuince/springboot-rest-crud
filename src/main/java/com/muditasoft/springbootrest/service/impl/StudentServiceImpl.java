package com.muditasoft.springbootrest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muditasoft.springbootrest.dao.StudentRepository;
import com.muditasoft.springbootrest.model.Student;
import com.muditasoft.springbootrest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

//	private StudentDao studentDao;
//	
//	@Autowired
//	public StudentServiceImpl(@Qualifier("studentDaoJpaImpl")StudentDao studentDao) {
//		this.studentDao = studentDao;
//	}

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// Remove @Transactional since JpaRepository provides this functionality
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		Optional<Student> result = studentRepository.findById(id);

		Student student = null;

		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new RuntimeException("Did not find student id - " + id);
		}

		return student;
	}

	@Override
	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
}

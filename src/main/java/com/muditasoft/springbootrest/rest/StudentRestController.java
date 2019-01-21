package com.muditasoft.springbootrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muditasoft.springbootrest.model.Student;
import com.muditasoft.springbootrest.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private StudentService studentService;
	
	// Inject StudentService to StudentRestController
	@Autowired
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}



	// expose "/students" and return list of employees
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.findAll();
	}
}

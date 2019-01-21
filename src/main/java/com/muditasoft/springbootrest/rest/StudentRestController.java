package com.muditasoft.springbootrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// Add mapping for Get /students/{id}
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable(name = "id") Long id) {
		Student student = studentService.findById(id);
		
		if(student == null)
			throw new RuntimeException("Student id not found - " + id);
		
		return student;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		// also just in case they pass an id in JSON . . . set id to 0
		// this is to force a save of new item . . . instead of update
		
		student.setId(0L);
		studentService.saveOrUpdate(student);
		return student;
	}
}

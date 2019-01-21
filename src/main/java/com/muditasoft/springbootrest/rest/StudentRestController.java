package com.muditasoft.springbootrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// add mapping for POST /students - add new student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student;
	}
	
	// add mapping for PUT /students - update existing student
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student;
	}
	
	// add mapping for DELETE /students/{id} -  delete student
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable(name = "id") Long id) {
		Student student = studentService.findById(id);
		
		if(student == null)
			throw new RuntimeException("Student id not found - " + id);
		
		studentService.deleteById(id);
		
		return "Deleted student id - " + id;
	}
}

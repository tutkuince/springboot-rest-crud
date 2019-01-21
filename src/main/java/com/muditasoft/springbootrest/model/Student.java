package com.muditasoft.springbootrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	// Define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 45)
	private String name;

	@Column(name = "surname", length = 45)
	private String surname;

	@Column(name = "email", length = 45, unique = true)
	private String email;

	// Define constructors

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	
	// Define getter/setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	// Define toString method
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}

}

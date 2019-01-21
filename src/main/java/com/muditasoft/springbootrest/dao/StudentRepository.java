package com.muditasoft.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muditasoft.springbootrest.model.Student;

// @RepositoryRestResource(path = "students")   -> Specify plural name / path with an annotation
public interface StudentRepository extends JpaRepository<Student, Long> {

}

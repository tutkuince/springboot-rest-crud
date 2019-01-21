package com.muditasoft.springbootrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muditasoft.springbootrest.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

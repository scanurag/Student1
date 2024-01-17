package com.org.springbootschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.springbootschool.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}

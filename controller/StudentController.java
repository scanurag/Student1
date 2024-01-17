package com.org.springbootschool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.springbootschool.dao.StudentDao;
import com.org.springbootschool.dto.Student;

@RestController
public class StudentController {
	@Autowired
	StudentDao dao;
@PostMapping("/student")
public ResponseEntity<String> saveStudent(@RequestBody Student t) {
	boolean res =dao.saveStudent(t);
	if(res) {
		return ResponseEntity.of(Optional.of("Success"));
	}else {
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
}
@GetMapping("/student")
public ResponseEntity<List<Student>> getAllStudent(){
	List<Student> stu=dao.getAllStudent();
	if(stu.isEmpty()) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}else {
		return ResponseEntity.of(Optional.of(stu));
	}
}


@GetMapping("/student/{rollNo}")
public ResponseEntity<Student> getAllStudent(@PathVariable int rollNo){
	Student s=dao.findStudentById(rollNo);
	if(s!=null) {
		return ResponseEntity.of(Optional.of(s));
		
	
	}else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
@DeleteMapping("/student/{rollNo}")
public ResponseEntity<String> deleteStudentById(@PathVariable int rollNo){
	boolean res=dao.deleteStudent(rollNo);
	if(res) {
		return ResponseEntity.of(Optional.of("Success"));
	}
	else {
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
}
@PatchMapping("/student/{rollNo}")
public ResponseEntity<String> updateStudent(@RequestBody Student s) {
	boolean res =dao.updateStudent(s);
	if(res) {
		return ResponseEntity.of(Optional.of("Success"));
	}else {
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
}
}
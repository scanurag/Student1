package com.org.springbootschool.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.springbootschool.dto.Student;
import com.org.springbootschool.repository.StudentRepo;

@Component
public class StudentDao {
	@Autowired
	StudentRepo repo;
	
	public boolean saveStudent(Student s) {
		try {
			repo.save(s);
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}
	public List<Student> getAllStudent(){
		return repo.findAll();
	}
	public Student findStudentById(int id) {
		Optional<Student> o=repo.findById(id);
		if(o.isEmpty()) {
			return null;
		}else {
			return o.get();
		}
	}
public boolean deleteStudent(int rollNo) {
	Student s=findStudentById(rollNo);
	if(s!=null) {
		repo.delete(s);
		return true;
	}
	return false;
}
public boolean updateStudent(Student s) {
	try {
		repo.save(s);
		return true;
	}catch (Exception e) {
		
	}
	return false;
}
}

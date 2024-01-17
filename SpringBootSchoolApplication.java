package com.org.springbootschool;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.org.springbootschool.dto.Student;

@SpringBootApplication
public class SpringBootSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchoolApplication.class, args);
		 Student s=new  Student();
		}

}

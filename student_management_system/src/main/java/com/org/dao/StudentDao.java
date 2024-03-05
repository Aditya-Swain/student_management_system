package com.org.dao;

import java.util.List;

import com.org.dto.Student;

public interface StudentDao {
		
	 void saveAndUpdateStudent(Student student);
	
	 List<Student> fetchAllStudent();
	 
	 Student fetchStudentById(int id);
	 
	 void removeStudentById(int id);
}

package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.StudentDao;
import com.org.dto.Student;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	@PostMapping("/save_student")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		
		studentDao.saveAndUpdateStudent(student);
		
		ModelAndView mav = new ModelAndView("fetch_student");
		
		return mav;
	}
	
	@PostMapping("/fetch_student")
	public ModelAndView fetchStudent() {
		
		List<Student> students = studentDao.fetchAllStudent();
		
		ModelAndView mav = new ModelAndView("home.jsp");
		mav.addObject("students", students);
		return mav;
		
		
	}
	@GetMapping("/update_student")
	public ModelAndView updateStudent(@RequestParam int id) {
		
		Student student = studentDao.fetchStudentById(id);
		
		ModelAndView mav = new ModelAndView("add_student.jsp");
		mav.addObject("student", student);
		
		return mav;
		
	}
	
	@GetMapping("/delete_student")
	public ModelAndView deleteStudent(@RequestParam int id) {
		
		studentDao.removeStudentById(id);
		
		ModelAndView mav = new ModelAndView("fetch_student1");
		
		return mav;
		
	}
	
	@GetMapping("/fetch_student1")
	public ModelAndView fetchStudent1() {
		
		List<Student> students = studentDao.fetchAllStudent();
		
		ModelAndView mav = new ModelAndView("home.jsp");
		mav.addObject("students", students);
		return mav;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}

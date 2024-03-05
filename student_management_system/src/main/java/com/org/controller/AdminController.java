package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.AdminDao;
import com.org.dto.Admin;
import com.org.dto.Student;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;
	@PostMapping("/login")
	public ModelAndView adminLogin(@RequestParam String email ,@RequestParam String password) {
		
		List<Admin> verification = adminDao.login(email, password);
		
		if(!verification.isEmpty()) {
			Admin admin = verification.get(0);
			ModelAndView mav = new ModelAndView("fetch_student");
			mav.addObject("adminId", admin.getId());
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("login.jsp");
		mav.addObject("fail", "Invalid Email or Password");
		return mav;
		
	}
	
	@GetMapping("/add_student")
	public ModelAndView addStudent() {
		
		Student student = new Student();
		
		ModelAndView mav = new ModelAndView("add_student.jsp");
		
		mav.addObject("student", student);
		
		return mav;
		
		
	}
	
	@GetMapping("/admin_profile")
	public ModelAndView adminProfile() {
		
		Admin admin = adminDao.fetchById(1);
		
		ModelAndView mav = new ModelAndView("admin_profile.jsp");
		
		mav.addObject("adminObj",admin);
		return mav;
		
		
	}
	
	@GetMapping("/logout")
	public ModelAndView adminLogout(HttpSession session) {
			
		session.removeAttribute("adminId");
		ModelAndView mav = new ModelAndView("index.jsp");
			
		return mav;
	}
	
	
	
	
	
	

}

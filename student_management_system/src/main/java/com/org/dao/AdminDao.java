package com.org.dao;

import java.util.List;

import com.org.dto.Admin;

public interface AdminDao {
	
	void saveAdmin(Admin admin);
	
	Admin fetchById(int id);
	
	List<Admin> login(String email ,String password);

}

package com.niit.dao;

import com.niit.model.User;

public interface UserDao {

	public void registerUser(User user);
	public boolean isEmailUnique(String email);
		
	
	
}

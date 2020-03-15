package com.nathanlesmann.capstone.petsitter.dao;

import java.util.List;

import com.nathanlesmann.capstone.petsitter.entity.User;



public interface UserDao {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
}

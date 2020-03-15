package com.nathanlesmann.capstone.petsitter.service;

import java.util.List;

import com.nathanlesmann.capstone.petsitter.entity.User;

/**
 * @author nlesmann
 *
 */
public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
	
}

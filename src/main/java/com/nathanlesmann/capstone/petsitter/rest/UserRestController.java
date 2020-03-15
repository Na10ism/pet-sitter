package com.nathanlesmann.capstone.petsitter.rest;

import java.util.List;

import com.nathanlesmann.capstone.petsitter.entity.User;
import com.nathanlesmann.capstone.petsitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}

	/**
	 * @return
	 */
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	// add mapping for GET /users/{userId}
	@GetMapping("/users/{user_id}")
	public User getUser(@PathVariable int user_id) {
		User theUser = userService.findById(user_id);

		if (theUser == null) {
			throw new RuntimeException("User id not found - " + user_id);
		}

		return theUser;
	}

	// add mapiing for POST /user - add new user
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {

		// also just in case they pass an id in JSON .... set id to 0
		// this is to force a save of a new item... instead of update

		theUser.setUser_id(0);

		userService.save(theUser);

		return theUser;

	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		userService.save(theUser);
		return theUser;
	}
	
	@DeleteMapping("/users/{user_id}")
	public String deleteUser(@PathVariable int user_id) {
		
		User tempUser = userService.findById(user_id);
		
		//throw exception
		if(tempUser == null) {
			throw new RuntimeException("User id not found - " + user_id);
		}
		userService.deleteById(user_id);
		
		return "Deleted User: \n" + tempUser;
	}
	

}

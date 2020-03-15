package com.nathanlesmann.capstone.petsitter.service;

import java.util.List;

import com.nathanlesmann.capstone.petsitter.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nathanlesmann.capstone.petsitter.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao theUserDao) {
		userDao = theUserDao;
	}
	@Override
	@Transactional
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	@Transactional
	public User findById(int theId) {

		return userDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(User theUser) {
		userDao.save(theUser);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		userDao.deleteById(theId);
	}

}

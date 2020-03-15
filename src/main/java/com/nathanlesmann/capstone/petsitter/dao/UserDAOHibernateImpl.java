package com.nathanlesmann.capstone.petsitter.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nathanlesmann.capstone.petsitter.entity.User;



@Repository
public class UserDAOHibernateImpl implements UserDao {
	
	// define field for entitymanager
	private EntityManager entityManager;
	
			// set up constructor injection
	@Autowired
	public UserDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<User> findAll(){
		
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<User> theQuery =
				currentSession.createQuery("from User", User.class);
		
		// execute the query and get result list
		List<User> users = theQuery.getResultList();
		
		// return the results
		return users;
	}

	@Override
	public User findById(int theId) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the user
		User theUser  = 
				currentSession.get(User.class, theId);
		// return the user
		return theUser;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theUser);

		
	}

	// the query might not work
	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = 
				currentSession.createQuery("delete from User where id=:userId");
		
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();
	}

}

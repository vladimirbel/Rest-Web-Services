package com.in28minutes.electronicsstore.RestWebServices.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.electronicsstore.RestWebServices.Entity.User;

@Repository
@Transactional
public class UsersDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public User findById(int id) {
		return manager.find(User.class, id);
	}
	
	public List<User> findAll() {
		TypedQuery<User> namedQuery = manager.createNamedQuery("find_all_users",User.class);
		return namedQuery.getResultList();
	}
	
	public User delete(int id) {
		User user = manager.find(User.class, id);
		manager.remove(user);
		
		return user;
	}
	
	public void insert(User user) {
		manager.persist(user);
	}

}

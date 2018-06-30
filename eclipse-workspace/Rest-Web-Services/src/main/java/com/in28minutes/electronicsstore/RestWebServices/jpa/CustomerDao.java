package com.in28minutes.electronicsstore.RestWebServices.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.electronicsstore.RestWebServices.Entity.Customer;

@Repository
@Transactional
public class CustomerDao {
	

	
	@PersistenceContext
	private EntityManager manager;
	
	
	public Customer findById(int id) {
		Customer customer = manager.find(Customer.class, id);
		
		return customer;
	}
	
	public List<Customer> findAll() {
		TypedQuery<Customer> namedQuery = manager.createNamedQuery("find_all_customers", Customer.class);
		
		return namedQuery.getResultList();
	}
	
	public Customer delete(int id) { 
		Customer customer = manager.find(Customer.class, id);
		manager.remove(customer);
		
		return customer;
	}
	
	public void insert(Customer customer) {
		manager.persist(customer);
		
	}
}

package com.in28minutes.electronicsstore.RestWebServices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.electronicsstore.RestWebServices.Entity.Customer;
import com.in28minutes.electronicsstore.RestWebServices.jpa.CustomerDao;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerDao custDao;
	
	@GetMapping(path="/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = custDao.findAll();
		
		return customers;
	}
	
	
	@GetMapping(path="/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = custDao.findById(customerId);
		
		if(customer == null) {
			throw new ProductNotFoundException("Customer doesn't exist for id: " + customerId);
		}
		
		return customer;
	}
	
	@DeleteMapping(path="/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		custDao.delete(customerId);
	}
	
	@PostMapping(path="/customers")
	public void insertCustomer(@RequestBody Customer customerArg) {
		custDao.insert(customerArg);
	}
}

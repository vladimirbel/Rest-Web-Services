package com.in28minutes.electronicsstore.RestWebServices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.electronicsstore.RestWebServices.Entity.User;
import com.in28minutes.electronicsstore.RestWebServices.jpa.UsersDao;

@RestController
public class UserController {
	
	@Autowired
	UsersDao users;
	
	@GetMapping(path="/users")
	public List<User> getUsers() {
		return users.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User getUser(@PathVariable int id) {
		return users.findById(id);
	}
	
	@DeleteMapping(path="/users/{id}")
	public User deleteUser(@PathVariable  int id) {
		User user = users.findById(id);
		users.delete(id);
		
		return user;
	}
	
	@PostMapping(path="/users")
	public void insertUser(@RequestBody User user) {
		users.insert(user);
	}
}

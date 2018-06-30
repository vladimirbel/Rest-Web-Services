package com.in28minutes.electronicsstore.RestWebServices.Controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.electronicsstore.RestWebServices.Entity.Product;
import com.in28minutes.electronicsstore.RestWebServices.Entity.StoreBean;
import com.in28minutes.electronicsstore.RestWebServices.jpa.ProductDao;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(path="/storeName")
	public StoreBean storeName() {
		return new StoreBean("Crazy Eddie's Electronics");
	}
	
	@GetMapping(path="/products/{productId}")
	public Resource<Product> productDescription(@PathVariable int productId) {
		Product product = productDao.findById(productId);
		
		if(product == null) {
			throw new ProductNotFoundException("Not found id-" + productId);
		}
		
		Resource<Product> resource = new Resource<Product>(product);
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getProducts());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		
		return resource;
	}
	
	@GetMapping(path="/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productDao.findAll();
		
		  HttpHeaders responseHeaders = new HttpHeaders();
		  responseHeaders.set("Access-Control-Allow-Origin", "*");
		
		return new ResponseEntity<List<Product>>(products, responseHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/products")
	public ResponseEntity<Object> insertProduct(@Valid @RequestBody Product productArg) {
		Product product = productDao.save(productArg);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(product.getPRODUCT_ID()).toUri();
			
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/products/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		Product product = productDao.deleteById(productId);
		
		if(product == null) {
			throw new ProductNotFoundException("id-" + productId);
		}
	}

}

package com.in28minutes.electronicsstore.RestWebServices.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.electronicsstore.RestWebServices.Entity.Product;



@Repository
@Transactional
public class ProductDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public List<Product> findAll() {
		TypedQuery<Product> namedQuery = entityManager.createNamedQuery("find_all_products", Product.class);
		return namedQuery.getResultList();
	}
	
	public Product findById(int id) {
		Product prod = entityManager.find(Product.class, new Integer(id));
		
		return prod;
	}
	
	public Product update(Product product) {
		return entityManager.merge(product);
	}

	public Product save(Product product) {
		return entityManager.merge(product);
	}

	public Product deleteById(int id) {
		Product product = findById(id);
		entityManager.remove(product);
		
		return product;
	}
	
	
}

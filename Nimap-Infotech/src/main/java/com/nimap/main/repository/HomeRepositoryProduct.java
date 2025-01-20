package com.nimap.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nimap.main.model.Product;

@Repository
public interface HomeRepositoryProduct extends JpaRepository<Product, Integer> {

	public Product findById(int id); 
	
}

package com.nimap.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.main.model.Product;

public interface HomeServiceProduct {

	public void saveProductdata(Product p);

	public Iterable getAllProduct();

	public Product getProductById(int id);

	public void deleteProductById(int id);

	public Product findById(int id);

	public Page<Product> getAllProductbyPage(Pageable paging);

}

package com.nimap.main.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.main.model.Product;
import com.nimap.main.repository.HomeRepositoryProduct;
import com.nimap.main.service.HomeServiceProduct;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HomeServiceImpProduct implements HomeServiceProduct {

	@Autowired
	HomeRepositoryProduct hrp;

	@Override
	public void saveProductdata(Product p) {
		// TODO Auto-generated method stub
		hrp.save(p);
	}

	@Override
	public Iterable getAllProduct() {
		// TODO Auto-generated method stub
		return hrp.findAll();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return hrp.findById(id);
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		hrp.deleteById(id);
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return hrp.findById(id);
	}

	@Override
	public Page<Product> getAllProductbyPage(Pageable paging) {
		// TODO Auto-generated method stub
		return hrp.findAll(paging);
	}
	
}

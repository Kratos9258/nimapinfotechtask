package com.nimap.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.main.model.Product;
import com.nimap.main.service.HomeServiceCategory;
import com.nimap.main.service.HomeServiceProduct;

@RestController
@RequestMapping("api/products")
public class HomeControllerProduct {

	@Autowired
	HomeServiceProduct hsp;
	
	@Autowired
	HomeServiceCategory hsc;
	
	@GetMapping("/getall")
	public Iterable getProductData()
	{
		Iterable proddata = hsp.getAllProduct();
		
		return proddata;
	}
	
	@GetMapping("/{page}")
    public List<Product> getAllProducts(@PathVariable int page) 
		{
	   
        Pageable paging = PageRequest.of(page-1,3);
        Page<Product> pages = hsp.getAllProductbyPage(paging);
 
      
        return pages.getContent();
        
    }
	
	@PostMapping("/")
	public String postProductData(@RequestBody Product p)
	{
		hsp.saveProductdata(p);
		
		return "Added a Product Succesfully";
	}
	
	@GetMapping("/get/{id}")
	public Product getProductDataById(@PathVariable("id") int id)
	{
		Product prodDataById = hsp.getProductById(id);
		
		return prodDataById;
	}
	
	@PutMapping("/update/{id}")
	public String updateProductData(@PathVariable("id") int id,@RequestBody Product p)
	{
		Product psave = hsp.findById(id);
		
		psave.setProductName(p.getProductName());
		psave.setProductPrice(p.getProductPrice());
		psave.setMfgDate(p.getMfgDate());
		hsp.saveProductdata(psave);
		
		return "Update a Product Succesfully";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProductDataById(@PathVariable("id") int id)
	{
		hsp.deleteProductById(id);
		
		return "Deleted a Product Successfully";
	}
	
	
}

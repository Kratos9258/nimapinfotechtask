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

import com.nimap.main.model.Category;
import com.nimap.main.service.HomeServiceCategory;
import com.nimap.main.service.HomeServiceProduct;

@RestController
@RequestMapping("api/categories")
public class HomeControllerCategory {
	
	@Autowired
	HomeServiceCategory hsc;
	
	@Autowired
	HomeServiceProduct hsp;
	
	@GetMapping("/getAll")
	public Iterable getAllCategory()
	{
		Iterable catData=hsc.getAllCategory();
		
		return catData;
	}
	
	@GetMapping("/{page}")
    public List<Category> getAllCategory(@PathVariable int page) 
	{
	    // First page with 5 items
		Pageable paging = PageRequest.of(page-1, 1);
        Page<Category> pages = hsc.getAllCategoryByPage(paging);
 
        // Retrieve the items
        return pages.getContent();
        
    }
	
	@PostMapping("/")
	public String saveCategory(@RequestBody Category c)
	{
		hsc.saveCategoryData(c);
		return "Added a Category Succesfully";
	}
	
	@GetMapping("/getbyid/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId")int cid)
	{
		Category catDataById=hsc.getCategoryById(cid);
		
		return catDataById;
	}
	
	@PutMapping("/updatecategorybyId/{categoryId}")
	public String updateCategoryByCategoryId(@PathVariable("categoryId")int cid,@RequestBody Category c)
	{
		Category cat =hsc.getCategoryById(cid);
		
		cat.setCategoryType(c.getCategoryType());
		cat.setCategoryInfo(c.getCategoryInfo());
		
		hsc.saveCategoryData(cat);
		
		return "Updated a Category Successfully";
	}
	
	@DeleteMapping("delete/{categoryId}")
	public String deleteCategoryByCtegoryId(@PathVariable("categoryId")int cid)
	{
		hsc.deleteCategoryById(cid);
		return "Deleted a Category Succesfully";
	}

}

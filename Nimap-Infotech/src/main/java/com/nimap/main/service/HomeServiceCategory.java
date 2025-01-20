package com.nimap.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.main.model.Category;

public interface HomeServiceCategory {

	public void saveCategoryData(Category c);

	public Category getCategoryById(int cid);

	public void deleteCategoryById(int cid);

	public Iterable getAllCategory();

	public Page<Category> getAllCategoryByPage(Pageable paging);

}

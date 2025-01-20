package com.nimap.main.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.main.model.Category;
import com.nimap.main.repository.HomeRepositoryCategory;
import com.nimap.main.service.HomeServiceCategory;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class HomeServiceImpCategory implements HomeServiceCategory {
	
	@Autowired
	HomeRepositoryCategory hrc;

	@Override
	public void saveCategoryData(Category c) {
		// TODO Auto-generated method stub
		hrc.save(c);
	}

	@Override
	public Category getCategoryById(int cid) {
		// TODO Auto-generated method stub
		return hrc.findById(cid);
	}

	@Override
	public void deleteCategoryById(int cid) {
		// TODO Auto-generated method stub
		hrc.deleteById(cid);
	}

	@Override
	public Iterable getAllCategory() {
		// TODO Auto-generated method stub
		return hrc.findAll();
	}

	@Override
	public Page<Category> getAllCategoryByPage(Pageable paging) {
		// TODO Auto-generated method stub
		return hrc.findAll(paging);
	}

}

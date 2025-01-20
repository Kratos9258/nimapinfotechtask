package com.nimap.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.main.model.Category;

@Repository
public interface HomeRepositoryCategory extends JpaRepository<Category, Integer>{

	public Category findById(int cid);
}

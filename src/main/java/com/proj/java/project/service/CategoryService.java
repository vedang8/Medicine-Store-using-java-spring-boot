package com.proj.java.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.java.project.entity.Category;
import com.proj.java.project.repository.CategoryDao;
//import com.proj.java.project.repository.CategotyDao;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao cd;

	public Category getCate(int id) {
		return cd.getCategory(id);
	}
	 
	public List<Category> getcategories() {
		return cd.getcategories();
	}

	public void addCategory(final Category c) {
		cd.addCate(c);
	}

	public void updatecategory(final Category c) {
		cd.updateCategory(c);
	}
//
	public void deletecategory(final int id) {
		cd.deleteCategory(id);
	}
	
}


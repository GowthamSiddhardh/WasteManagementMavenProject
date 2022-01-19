package com.cleaningmanagement.dao;

import java.util.List;

import com.cleaningmanagement.model.CategoryDetails;

public interface CategoryDao {
	public int insertCategoryDetails(CategoryDetails cat);
	public CategoryDetails findAmount(String category);
	public List<CategoryDetails> listdetails();
}

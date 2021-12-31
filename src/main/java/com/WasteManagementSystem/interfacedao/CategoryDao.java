package com.WasteManagementSystem.interfacedao;

import com.cleaningmanagement.model.CategoryDetails;

public interface CategoryDao {
	public int insertCategoryDetails(CategoryDetails cat);
	public CategoryDetails findAmount(String category);
}

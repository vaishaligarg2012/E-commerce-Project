package com.MVCStart.Daos;

import java.util.List;

import com.MVCStart.Models.Category;

public interface CategoryDao {
     public boolean addCategory(Category category);
     public List<Category> viewAllCategory();
     public Category viewCategoryById(int catId);
     public boolean deleteCategory(Category cat);
     public boolean updateCategory(Category category);
     
}

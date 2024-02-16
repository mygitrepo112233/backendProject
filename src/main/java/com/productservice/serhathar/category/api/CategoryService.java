package com.productservice.serhathar.category.api;

import com.productservice.serhathar.category.api.CategoryDto;
import com.productservice.serhathar.category.impl.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto dto);
    List<CategoryDto> getAllCategory();
    Category getById(String id);
    void deleteCategory(String id);
    CategoryDto updateCategory(String id , CategoryDto dto);
    Category getByName(String name);
}
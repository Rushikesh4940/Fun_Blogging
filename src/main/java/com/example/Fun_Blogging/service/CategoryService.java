package com.example.Fun_Blogging.service;

import com.example.Fun_Blogging.entityDTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public CategoryDTO createCategory(CategoryDTO categoryDTO);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO,Integer categoryId);
    public  void deleteCategory(Integer categoryId);
    CategoryDTO getCategory(Integer categoryId);
    public List<CategoryDTO> getAllCategory();
}

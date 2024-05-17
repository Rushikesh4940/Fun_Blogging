package com.example.Fun_Blogging.service;

import com.example.Fun_Blogging.entity.Category;
import com.example.Fun_Blogging.entityDTO.CategoryDTO;
import com.example.Fun_Blogging.exception.ResourceNotFoundException;
import com.example.Fun_Blogging.repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category= this.modelMapper.map(categoryDTO, Category.class);
        Category addedCategory =this.categoryRepo.save(category);
        return  this.modelMapper.map(addedCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(category.getCategoryDescription());
        this.categoryRepo.save(category);
        return  this.modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        return this.modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> category = this.categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = category.stream().map((category1) -> this.modelMapper.map(category1, CategoryDTO.class)).collect(Collectors.toList());
        return categoryDTOS;
    }
}

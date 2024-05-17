package com.example.Fun_Blogging.controller;

import com.example.Fun_Blogging.entityDTO.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createcate
}

package com.example.Fun_Blogging.repository;

import com.example.Fun_Blogging.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}

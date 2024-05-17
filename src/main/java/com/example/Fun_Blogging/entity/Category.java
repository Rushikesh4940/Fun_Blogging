package com.example.Fun_Blogging.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

@Data
@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private  String categoryTitle;
    private String categoryDescription;
}

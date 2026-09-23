package com.project.vitor.controllers;


import com.project.vitor.entities.Category;
import com.project.vitor.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping( value = "/categories")
public class CategoryController {

    @Autowired
    CategoryService CategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> Category = CategoryService.findAll();
        return ResponseEntity.ok().body(Category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category Category = CategoryService.findById(id);
        return ResponseEntity.ok().body(Category);
    }
}

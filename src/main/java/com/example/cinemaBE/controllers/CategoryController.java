package com.example.cinemaBE.controllers;


import com.example.cinemaBE.domains.Category;
import com.example.cinemaBE.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<Category> list() {
        return categoryService.listAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = categoryService.getCategory(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable String code) {
        try {
            category.setCode(code);
            categoryService.saveCategory(category);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
package com.example.cinemaBE.controllers;


import com.example.cinemaBE.domains.Actor;
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

    @GetMapping("/{code}")
    public ResponseEntity<Category> get(@PathVariable String code) {
        try {
            Category category = categoryService.getCategory(code);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        try {
            categoryService.saveCategory(category);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String code) {
        categoryService.deleteCategory(code);
    }
}
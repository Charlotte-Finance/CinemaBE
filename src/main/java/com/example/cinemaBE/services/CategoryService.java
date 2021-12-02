package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Category;
import com.example.cinemaBE.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAllCategory() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategory(String code) {
        return categoryRepository.findById(code).get();
    }

    public void deleteCategory(String code) {
        categoryRepository.deleteById(code);
    }

}
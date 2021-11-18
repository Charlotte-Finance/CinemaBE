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

    public Category getCategory(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
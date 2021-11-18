package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
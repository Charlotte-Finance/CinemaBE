package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
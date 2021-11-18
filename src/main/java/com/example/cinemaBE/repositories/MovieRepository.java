package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
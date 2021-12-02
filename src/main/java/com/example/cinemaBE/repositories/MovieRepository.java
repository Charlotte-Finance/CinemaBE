package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findById(int id);

    List<Movie> findByCategoryCode(String categoryCode);

    List<Movie> findByDirectorId(int directorId);

}
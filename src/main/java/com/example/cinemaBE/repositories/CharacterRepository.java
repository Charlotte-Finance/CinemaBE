package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Actor;
import com.example.cinemaBE.domains.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    List<Character> findByMovieId(int movieId);

}
package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
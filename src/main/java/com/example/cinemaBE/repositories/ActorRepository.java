package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
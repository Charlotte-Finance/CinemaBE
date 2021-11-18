package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
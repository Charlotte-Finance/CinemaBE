package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Director;
import com.example.cinemaBE.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> listAllDirector() {
        return directorRepository.findAll();
    }

    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director getDirector(Integer id) {
        return directorRepository.findById(id).get();
    }

    public void deleteDirector(Director director) {
        directorRepository.deleteById(director.getId());
    }
}
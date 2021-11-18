package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Actor;
import com.example.cinemaBE.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> listAllActor() {
        return actorRepository.findAll();
    }

    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }

    public Actor getActor(Integer id) {
        return actorRepository.findById(id).get();
    }

    public void deleteActor(Integer id) {
        actorRepository.deleteById(id);
    }
}
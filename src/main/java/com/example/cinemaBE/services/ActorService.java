package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Actor;
import com.example.cinemaBE.domains.Character;
import com.example.cinemaBE.repositories.ActorRepository;
import com.example.cinemaBE.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private CharacterRepository characterRepository;

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

    public List<Actor> getActorsByMovieId(int movieId) {
        List<Character> characters = characterRepository.findByMovieId(movieId);
        List<Actor> actors = new ArrayList<>();
        for (Character character : characters) {
            actors.add(actorRepository.getById(character.getActorId()));
        }
        return actors;
    }
}
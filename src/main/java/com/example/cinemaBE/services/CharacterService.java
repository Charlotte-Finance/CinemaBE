package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Character;
import com.example.cinemaBE.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> listAllCharacter() {
        return characterRepository.findAll();
    }

    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character getCharacter(Integer id) {
        return characterRepository.findById(id).get();
    }

    public void deleteCharacter(Character character) {
        characterRepository.deleteById(character.getId());
    }

    public List<Character> getCharactersByMovie(Integer movieId) {
        return characterRepository.findByMovieId(movieId);
    }

}
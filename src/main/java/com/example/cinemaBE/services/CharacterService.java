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

    public void saveCharacter(Character character) {
        characterRepository.save(character);
    }

    public Character getCharacter(Integer id) {
        return characterRepository.findById(id).get();
    }

    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }
}
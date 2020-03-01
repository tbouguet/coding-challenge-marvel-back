package com.coding.challenge.marvel.controller;

import com.coding.challenge.marvel.services.character.CharacterService;
import com.coding.challenge.marvel.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/characters")
@CrossOrigin
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    @GetMapping
    public List<Character> getCharacters(@RequestParam("offset") String offset) throws NoSuchAlgorithmException, IOException {
        return characterService.getCharacters(offset);
    }


}

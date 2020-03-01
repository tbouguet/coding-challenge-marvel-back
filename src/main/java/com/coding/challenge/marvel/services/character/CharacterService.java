package com.coding.challenge.marvel.services.character;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import com.coding.challenge.marvel.models.Character;
public interface CharacterService {

    /**
     * Get all characters by a remote call
     * @param offset
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    List<Character> getCharacters(String offset) throws NoSuchAlgorithmException, IOException;


}

package com.coding.challenge.marvel.services.character;
import com.coding.challenge.marvel.models.Character;
import com.coding.challenge.marvel.utils.MarvelUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {


    @Value("${marvel.key.public}")
    private String publicKey;

    @Value("${marvel.key.private}")
    private String privateKey;

    @Value("${marvel.url}")
    private String url;

    @Override
    public List<Character> getCharacters(String offset) throws NoSuchAlgorithmException, IOException {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = getResponseEntity(offset, restTemplate);

        List<Character> characters = getCharacters(response);

        return characters;
    }

    /**
     * Create hash and get result
     * @param offset
     * @param restTemplate
     * @return
     * @throws NoSuchAlgorithmException
     */
    private ResponseEntity<String> getResponseEntity(String offset, RestTemplate restTemplate) throws NoSuchAlgorithmException {
        String ts ="2";
        String value = StringUtils.join(ts, privateKey, publicKey);
        String hash = MarvelUtils.createHash(value).toLowerCase();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("offset", offset)
                .queryParam("ts", ts)
                .queryParam("apikey", publicKey)
                .queryParam("hash", hash);


        return restTemplate
                .getForEntity(builder.toUriString(), String.class);
    }

    /**
     * Deserialize json
     * @param response
     * @return
     * @throws IOException
     */
    private List<Character> getCharacters(ResponseEntity<String> response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode nodeBody = objectMapper.readTree(response.getBody());
        JsonNode nodeData = nodeBody.get("data").get("results");
        return objectMapper.readValue(nodeData.toString(), new TypeReference<List<Character>>() {});
    }


}

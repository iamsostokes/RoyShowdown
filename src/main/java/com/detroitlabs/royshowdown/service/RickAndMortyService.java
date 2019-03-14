package com.detroitlabs.royshowdown.service;

import com.detroitlabs.royshowdown.model.CartoonCharacter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class RickAndMortyService {

    public CartoonCharacter fetchSingleCharacter() {
        int characterNumber = generateRandomNumberForCharacter();

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://rickandmortyapi.com/api/" +
                "character/" + characterNumber, CartoonCharacter.class);
    }


    private int generateRandomNumberForCharacter(){
        Random random = new Random();
        return random.nextInt(493) + 1;
    }

}

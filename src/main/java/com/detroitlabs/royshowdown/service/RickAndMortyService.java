package com.detroitlabs.royshowdown.service;

import com.detroitlabs.royshowdown.model.CartoonCharacter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RickAndMortyService {

    public CartoonCharacter fetchSingleCharacter(int randomNum) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://rickandmortyapi.com/api/" +
                "character/" + randomNum, CartoonCharacter.class);
    }

}

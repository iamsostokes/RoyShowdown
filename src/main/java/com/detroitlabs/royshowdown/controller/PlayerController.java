package com.detroitlabs.royshowdown.controller;

import com.detroitlabs.royshowdown.model.CartoonCharacter;
import com.detroitlabs.royshowdown.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlayerController {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    @RequestMapping("/")
    public String displayHomePage(ModelMap modelMap) {
        CartoonCharacter character = rickAndMortyService.fetchSingleCharacter(1);
        CartoonCharacter character2 = rickAndMortyService.fetchSingleCharacter(39);

        modelMap.put("character", character);
        modelMap.put("character2", character2);
        return "index";
    }

}

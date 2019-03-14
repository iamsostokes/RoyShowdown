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
        CartoonCharacter character = rickAndMortyService.fetchSingleCharacter();;
        modelMap.put("character", character);
        return "index";
    }

    @RequestMapping("/jobsearch")
    public String displayJobPage(ModelMap modelMap) {
        CartoonCharacter character = rickAndMortyService.fetchSingleCharacter();;
        modelMap.put("character", character);
        return "jobPage";
    }

    @RequestMapping("/readytorumble")
    public String displayPlayerProfiles(ModelMap modelMap) {
        CartoonCharacter character = rickAndMortyService.fetchSingleCharacter();;
        modelMap.put("character", character);
        return "preShowdown";
    }

}

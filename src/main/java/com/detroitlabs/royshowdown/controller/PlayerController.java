package com.detroitlabs.royshowdown.controller;

import com.detroitlabs.royshowdown.model.CartoonCharacter;
import com.detroitlabs.royshowdown.model.Job;
import com.detroitlabs.royshowdown.model.JobSearchRepository;
import com.detroitlabs.royshowdown.service.JobService;
import com.detroitlabs.royshowdown.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PlayerController {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    @Autowired
    private JobService jobService;

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

    @RequestMapping("/winnercircle")
    public String displayWinnerPage(ModelMap modelMap) {
        CartoonCharacter character = rickAndMortyService.fetchSingleCharacter();;
        modelMap.put("character", character);
        return "winnerPage";
    }

    @RequestMapping("/test")
    public String displayJob(ModelMap modelMap) {
        JobSearchRepository searchRepo = jobService.fetchAllJobs();
        ArrayList<Job> positionTitle = searchRepo.getSearchResult().getSearchResultItems();

        modelMap.put("jobResults", positionTitle);
        modelMap.put("languageCode",searchRepo.getLanguageCode());
        return "testTemplate";
    }

}

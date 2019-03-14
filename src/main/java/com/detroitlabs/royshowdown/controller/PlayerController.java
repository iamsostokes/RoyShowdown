package com.detroitlabs.royshowdown.controller;

import com.detroitlabs.royshowdown.model.*;
import com.detroitlabs.royshowdown.service.JobService;
import com.detroitlabs.royshowdown.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class PlayerController {

    private Game currentGame;

    @Autowired
    private RickAndMortyService rickAndMortyService;

    @Autowired
    private JobService jobService;

    @RequestMapping("/")
    public String displayHomePage(ModelMap modelMap) {
        currentGame = new Game();

        CartoonCharacter character1 = rickAndMortyService.fetchSingleCharacter();
        CartoonCharacter character2 = rickAndMortyService.fetchSingleCharacter();

        getCurrentPlayerOne().setCartoonCharacter(character1);
        getCurrentPlayerTwo().setCartoonCharacter(character2);

       setAllPlayersImageOnModelMap(modelMap);

        return "index";
    }

    @RequestMapping("/jobsearch")
    public String displayJobPage(ModelMap modelMap) {

        setAllPlayersImageOnModelMap(modelMap);
        setAllPlayersNamesOnModelMap(modelMap);

        return "jobPage";
    }

    @RequestMapping("/readytorumble")
    public String displayPlayerProfiles(ModelMap modelMap) {

        setAllPlayersImageOnModelMap(modelMap);
        setAllPlayersNamesOnModelMap(modelMap);
        setAllPlayersJobNamesOnModelmap(modelMap);


        return "preShowdown";
    }

    @RequestMapping("/winnercircle")
    public String displayWinnerPage(ModelMap modelMap) {

        setAllPlayersImageOnModelMap(modelMap);
        setAllPlayersNamesOnModelMap(modelMap);
        setAllPlayersJobNamesOnModelmap(modelMap);

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

    private Player getCurrentPlayerOne(){
        return currentGame.getPlayers().get(0);
    }

    private Player getCurrentPlayerTwo(){
        return currentGame.getPlayers().get(1);
    }

    private void setAllPlayersImageOnModelMap(ModelMap modelMap){
        modelMap.put("playerOneImage", getCurrentPlayerOne().getCartoonCharacter().getImage());
        modelMap.put("playerTwoImage", getCurrentPlayerTwo().getCartoonCharacter().getImage());
    }

    private void setAllPlayersNamesOnModelMap(ModelMap modelMap){
        modelMap.put("playerOneName", getCurrentPlayerOne().getCartoonCharacter().getName());
        modelMap.put("playerTwoName", getCurrentPlayerTwo().getCartoonCharacter().getName());
    }

    private void setAllPlayersJobNamesOnModelmap(ModelMap modelmap){
        modelmap.put("playerOneJobName", getCurrentPlayerOne().getJob().getPositionTitle());
        modelmap.put("playerTwoJobName", getCurrentPlayerTwo().getJob().getPositionTitle());
    }

}

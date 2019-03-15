package com.detroitlabs.royshowdown.controller;

import com.detroitlabs.royshowdown.model.*;
import com.detroitlabs.royshowdown.service.JobService;
import com.detroitlabs.royshowdown.service.RickAndMortyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
//        setAllPlayersJobNamesOnModelmap(modelMap);
        return "jobPage";
    }

    @RequestMapping("/readytorumble")
    public String displayPlayerProfiles(ModelMap modelMap) {
//        JobSearchRepository searchRepo = jobService.fetchAllJobs();
//        Job playerJob1 = searchRepo.getSearchResult().getSearchResultItems().get(0);
//        Job playerJob2 = searchRepo.getSearchResult().getSearchResultItems().get(10);
//
//        getCurrentPlayerOne().setJob(playerJob1);
//        getCurrentPlayerTwo().setJob(playerJob2);

        JobSearchRepository jobSearchRepository = jobService.fetchAllJobs();
//        jobSearchRepository.getSearchResult().fetchSingleJob();

        Job jobForPlayer1 = jobSearchRepository.getSearchResult().fetchSingleJob();
        Job jobForPlayer2 = jobSearchRepository.getSearchResult().fetchSingleJob();

        getCurrentPlayerOne().setJob(jobForPlayer1);
        getCurrentPlayerTwo().setJob(jobForPlayer2);

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
        setAllPlayerSalariesOnModelMap(modelMap);
        modelMap.put("winner", determineWinner());

        return "winnerPage";
    }

    @RequestMapping("/test")
    public String displayJob(ModelMap modelMap) {
        JobSearchRepository searchRepo = jobService.fetchAllJobs();
        ArrayList<Job> positionTitle = searchRepo.getSearchResult().getSearchResultItems();

        modelMap.put("maximumRange", searchRepo.getSearchResult().getSearchResultItems().get(0).getMatchedObjectDescriptor().getPositionRemuneration().get(0).getMaximumRange());
        modelMap.put("positionTitle", searchRepo.getSearchResult().getSearchResultItems().get(0).getMatchedObjectDescriptor().getPositionTitle());
        modelMap.put("searchResultCount", searchRepo.getSearchResult().getSearchResultCount());
        modelMap.put("jobResults", positionTitle);
        modelMap.put("languageCode", searchRepo.getLanguageCode());
        return "testTemplate";
    }

    private Player getCurrentPlayerOne() {
        return currentGame.getPlayers().get(0);
    }

    private Player getCurrentPlayerTwo() {
        return currentGame.getPlayers().get(1);
    }

    private void setAllPlayersImageOnModelMap(ModelMap modelMap) {
        modelMap.put("playerOneImage", getCurrentPlayerOne().getCartoonCharacter().getImage());
        modelMap.put("playerTwoImage", getCurrentPlayerTwo().getCartoonCharacter().getImage());
    }

    private void setAllPlayersNamesOnModelMap(ModelMap modelMap) {
        modelMap.put("playerOneName", getCurrentPlayerOne().getCartoonCharacter().getName());
        modelMap.put("playerTwoName", getCurrentPlayerTwo().getCartoonCharacter().getName());
    }

    private void setAllPlayersJobNamesOnModelmap(ModelMap modelmap) {

        modelmap.put("playerOneJobName", getCurrentPlayerOne().getJob().getMatchedObjectDescriptor().getPositionTitle());
        modelmap.put("playerTwoJobName", getCurrentPlayerTwo().getJob().getMatchedObjectDescriptor().getPositionTitle());
    }

    private void setAllPlayerSalariesOnModelMap(ModelMap modelMap) {
        modelMap.put("playerOneSalary", getCurrentPlayerOne().getJob().getMatchedObjectDescriptor().getPositionRemuneration().get(0).getMaximumRange());
        modelMap.put("playerTwoSalary", getCurrentPlayerTwo().getJob().getMatchedObjectDescriptor().getPositionRemuneration().get(0).getMaximumRange());
    }

    public String getPlayerOneMaximumSalary() {
        SalaryRange playerOneSalaryRange = getCurrentPlayerOne().getJob().getMatchedObjectDescriptor().getPositionRemuneration().get(0);
        return playerOneSalaryRange.getMaximumRange();
    }

    public String getPlayerTwoMaximumSalary() {
        SalaryRange playerTwoSalaryRange = getCurrentPlayerTwo().getJob().getMatchedObjectDescriptor().getPositionRemuneration().get(0);
        return playerTwoSalaryRange.getMaximumRange();
    }

    public String getPlayerOneJobTitle() {
        return getCurrentPlayerOne().getJob().getMatchedObjectDescriptor().getPositionTitle();

    }

    public String getPlayerTwoJobTitle() {
        return getCurrentPlayerTwo().getJob().getMatchedObjectDescriptor().getPositionTitle();

    }

    public String determineWinner() {
        double playerOneSalaryToDouble = Double.parseDouble(getPlayerOneMaximumSalary());
        double playerTwoSalaryToDouble = Double.parseDouble(getPlayerTwoMaximumSalary());
        if (playerOneSalaryToDouble > playerTwoSalaryToDouble) {
            return "playerOneWins";
        } else if (playerTwoSalaryToDouble > playerOneSalaryToDouble) {
            return "playerTwoWins";
        } else {
            return "tie";
        }
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}

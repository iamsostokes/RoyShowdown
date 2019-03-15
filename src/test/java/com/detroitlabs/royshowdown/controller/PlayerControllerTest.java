package com.detroitlabs.royshowdown.controller;

import com.detroitlabs.royshowdown.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerControllerTest {

    @org.junit.Test
    public void shouldTestThatPlayerTwoWins() {

        PlayerController testController = new PlayerController();

        Game game1 = new Game();

        Player player1 = game1.getPlayers().get(0);
        Player player2 = game1.getPlayers().get(1);

        //Start player 1
        Job job1 = new Job();
        JobInfo jobInfo1 = new JobInfo();

        SalaryRange salaryRange1 = new SalaryRange();
        salaryRange1.setMaximumRange("100.00");
        ArrayList<SalaryRange> pay1 = new ArrayList<>();
        pay1.add(salaryRange1);

        jobInfo1.setPositionRemuneration(pay1);

        job1.setMatchedObjectDescriptor(jobInfo1);

        player1.setJob(job1);

        //Start player 2
        Job job2 = new Job();
        JobInfo jobInfo2 = new JobInfo();

        SalaryRange salaryRange2 = new SalaryRange();
        salaryRange2.setMaximumRange("200.00");
        ArrayList<SalaryRange> pay2 = new ArrayList<>();
        pay2.add(salaryRange2);

        jobInfo2.setPositionRemuneration(pay2);

        job2.setMatchedObjectDescriptor(jobInfo2);

        player2.setJob(job2);
        testController.setCurrentGame(game1);

        String actual = testController.determineWinner();
        assertEquals("playerTwoWins", actual);





    }

    @Test
    public void shouldTestThatPlayerOneWins() {

        PlayerController testController = new PlayerController();

        Game game1 = new Game();

        Player player1 = game1.getPlayers().get(0);
        Player player2 = game1.getPlayers().get(1);

        //Start player 1
        Job job1 = new Job();
        JobInfo jobInfo1 = new JobInfo();

        SalaryRange salaryRange1 = new SalaryRange();
        salaryRange1.setMaximumRange("200.00");
        ArrayList<SalaryRange> pay1 = new ArrayList<>();
        pay1.add(salaryRange1);

        jobInfo1.setPositionRemuneration(pay1);

        job1.setMatchedObjectDescriptor(jobInfo1);

        player1.setJob(job1);

        //Start player 2
        Job job2 = new Job();
        JobInfo jobInfo2 = new JobInfo();

        SalaryRange salaryRange2 = new SalaryRange();
        salaryRange2.setMaximumRange("100.00");
        ArrayList<SalaryRange> pay2 = new ArrayList<>();
        pay2.add(salaryRange2);

        jobInfo2.setPositionRemuneration(pay2);

        job2.setMatchedObjectDescriptor(jobInfo2);

        player2.setJob(job2);
        testController.setCurrentGame(game1);

        String actual = testController.determineWinner();
        assertEquals("playerOneWins", actual);


    }

    @Test
    public void shouldTestThatResultIsATie() {

        PlayerController testController = new PlayerController();

        Game game1 = new Game();

        Player player1 = game1.getPlayers().get(0);
        Player player2 = game1.getPlayers().get(1);

        //Start player 1
        Job job1 = new Job();
        JobInfo jobInfo1 = new JobInfo();

        SalaryRange salaryRange1 = new SalaryRange();
        salaryRange1.setMaximumRange("100.00");
        ArrayList<SalaryRange> pay1 = new ArrayList<>();
        pay1.add(salaryRange1);

        jobInfo1.setPositionRemuneration(pay1);

        job1.setMatchedObjectDescriptor(jobInfo1);

        player1.setJob(job1);

        //Start player 2
        Job job2 = new Job();
        JobInfo jobInfo2 = new JobInfo();

        SalaryRange salaryRange2 = new SalaryRange();
        salaryRange2.setMaximumRange("100.00");
        ArrayList<SalaryRange> pay2 = new ArrayList<>();
        pay2.add(salaryRange2);

        jobInfo2.setPositionRemuneration(pay2);

        job2.setMatchedObjectDescriptor(jobInfo2);

        player2.setJob(job2);
        testController.setCurrentGame(game1);

        String actual = testController.determineWinner();
        assertEquals("tie", actual);


    }
}
package com.detroitlabs.royshowdown.model;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;

    public Game(){
        this.players = new ArrayList<>();
        this.players.add(new Player());
        this.players.add(new Player());
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}

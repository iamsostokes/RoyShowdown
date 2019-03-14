package com.detroitlabs.royshowdown.model;

public class Player {

    private CartoonCharacter cartoonCharacter;
    private String name;
    private Job job;

    public CartoonCharacter getCartoonCharacter() {
        return cartoonCharacter;
    }

    public void setCartoonCharacter(CartoonCharacter cartoonCharacter) {
        this.cartoonCharacter = cartoonCharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}

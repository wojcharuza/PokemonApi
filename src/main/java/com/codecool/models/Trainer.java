package com.codecool.models;

import java.util.List;

public class Trainer {
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private List<Pokemon> pokemons;
    private List<Gym> gymsBeaten;


    public Trainer(){

    }

    public Trainer(String firstName, String lastName, String nickName, List<Pokemon> pokemons, List<Gym> gymsBeaten){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.pokemons = pokemons;
        this.gymsBeaten = gymsBeaten;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Gym> getGymsBeaten() {
        return gymsBeaten;
    }

    public void setGymsBeaten(List<Gym> gymsBeaten) {
        this.gymsBeaten = gymsBeaten;
    }
}

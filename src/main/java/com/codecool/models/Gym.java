package com.codecool.models;

public class Gym {

    private int id;
    private String name;
    private String type;
    private String location;
    private Trainer master;


    public Gym(){

    }

    public Gym(String name, String type, String location, Trainer master){
        this.name = name;
        this.type = type;
        this.location = location;
        this.master = master;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Trainer getMaster() {
        return master;
    }

    public void setMaster(Trainer master) {
        this.master = master;
    }
}

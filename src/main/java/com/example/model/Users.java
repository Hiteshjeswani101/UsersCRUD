package com.example.model;

public class Users {

    private int id;
    private String name;
    private String Location;

    public Users() {
    }

    public Users(int id, String name, String Location) {
        this.id = id;
        this.name = name;
        this.Location = Location;
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
}

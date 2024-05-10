package com.neog.helloproject.model;

public class User {
    private int id;
    private String name;
    //TODO: we can make it ENUM for user type
    private String type; // this is to represent if user is admin, instructor, mentor, TA or learner

    public User(){}

    public User(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

}

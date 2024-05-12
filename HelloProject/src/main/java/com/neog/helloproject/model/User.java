package com.neog.helloproject.model;

public class User {
    private int id;
    private String name;
    //TODO: we can make it ENUM for user type
    private UserType type; // this is to represent if user is admin, instructor, mentor, TA or learner

    public User(){}

    public User(int id, String name, UserType type) {
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

    public UserType getUserType() {
        return type;
    }

    public void setUserType(UserType type) {
        this.type = type;
    }
}

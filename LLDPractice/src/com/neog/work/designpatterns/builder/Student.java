package com.neog.work.designpatterns.builder;

public class Student {
    String name;
    int age;
    String batch;
    String universityName;
    double psp;
    String phoneNumber;

    public static Builder getBuilder(){
        return new Builder();
    }

    public Student(Builder builder){

        if(builder.age < 18){
            throw new RuntimeException("Student age cannot be less than 18");
        }

        if(builder.phoneNumber.length() < 10){
            throw new RuntimeException("Student phone number cannot be less than 10");
        }
        this.name = builder.getName();
        this.age = builder.getAge();
        this.batch = builder.getBatch();
        this.universityName = builder.getUniversityName();
        this.psp = builder.getPsp();
        this.phoneNumber = builder.getPhoneNumber();
    }
}

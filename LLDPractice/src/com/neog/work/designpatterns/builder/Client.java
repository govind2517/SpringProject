package com.neog.work.designpatterns.builder;

public class Client {
    public static void main(String[] args) {

        Student student = Student.getBuilder()
                        .setName("Govind")
                        .setAge(22)
                        .setPsp(80)
                        .setPhoneNumber("9878451256")
                        .build();

        System.out.println("student "+student);
        System.out.println("Completed...");
    }
}

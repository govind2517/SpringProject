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

    private Student(Builder builder){
        this.name = builder.getName();
        this.age = builder.getAge();
        this.batch = builder.getBatch();
        this.universityName = builder.getUniversityName();
        this.psp = builder.getPsp();
        this.phoneNumber = builder.getPhoneNumber();
    }

    // inner class
    public static class Builder {
        String name;
        int age;
        String batch;
        String universityName;
        double psp;
        String phoneNumber;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public Builder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Student build(){
            if(this.age < 18){
                throw new RuntimeException("Student age cannot be less than 18");
            }
            if(this.phoneNumber.length() < 10){
                throw new RuntimeException("Student phone number cannot be less than 10");
            }
            // if all validation is passed then only create object
            return new Student(this);
        }
    }
}

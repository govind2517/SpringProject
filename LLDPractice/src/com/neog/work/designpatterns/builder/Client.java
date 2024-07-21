package com.neog.work.designpatterns.builder;

public class Client {
    public static void main(String[] args) {
        //Builder b = new Builder();
        Builder b = Student.getBuilder();
        b.setName("Govind");
        b.setAge(18);
        b.setBatch("MorningBatch-Aug22");
        b.setPsp(90);
        b.setPhoneNumber("9845781251");
        b.setUniversityName("Mumbai University");
        //Student s = new Student(b);
        Student s = b.build();
        System.out.println(s);
    }
}

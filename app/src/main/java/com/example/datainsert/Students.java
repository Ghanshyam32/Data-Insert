package com.example.datainsert;

public class Students {

    String name;
    String rollNo;
    String course;

    public Students(String name, String rollNo, String course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;
    }
}

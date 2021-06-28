package com.schoollist.springapi.controller;


public class Requ {

    public Requ(String a) {
    this.School =a;

    }

    private String School;

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }
}

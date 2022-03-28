package com.stir.cscu9t4practical1;

public class Athlete {

    private String firstName;
    private String lastName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public Athlete(String fn, String ln, int bD, int bM, int bY) {
        firstName = fn;
        lastName = ln;
        birthDay = bD;
        birthMonth = bM;
        birthYear = bY;
    }//constructor

    // getter for first name
    public String getFirstName() {
        return firstName;
    }

    // setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // getter for last name
    public String getLastName() {
        return lastName;
    }

    // setter for first name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // getter for full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // getter for birth day
    public int getBirthDay() {
        return birthDay;
    }

    // setter for birth day
    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    // getter for birth month
    public int getBirthMonth() {
        return birthMonth;
    }

    // setter for birth month
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    // getter for birth year
    public int getBirthYear() {
        return birthYear;
    }

    // setter for birth year
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAthlete() {
        return "Athlete's name: " + firstName + " " + lastName + "\n Birthday " + birthDay + "/" + birthMonth + "/" + birthYear;
    }
}

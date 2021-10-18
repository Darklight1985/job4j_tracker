package ru.job4j.oop;

import java.util.Date;

public class Builder extends Engineer {
    private String instrument;

    @Override
    public int getIq() {
        return super.getIq();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String getEducation() {
        return super.getEducation();
    }

    @Override
    public Date getBirthday() {
        return super.getBirthday();
    }

    @Override
    public Idea creation() {
        return super.creation();
    }

    public House rising() {
        return new House();
    }

    public class House {
    }
}

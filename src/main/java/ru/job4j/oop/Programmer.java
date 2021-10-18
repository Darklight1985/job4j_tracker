package ru.job4j.oop;

import java.util.Date;

public class Programmer extends Engineer {
    private String specialisation;

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

    public Algoritm writing(Idea idea) {
     return new Algoritm();
    }

    class Algoritm {
    }
}



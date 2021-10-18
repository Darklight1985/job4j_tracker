package ru.job4j.oop;

import java.util.Date;

public class Dentist extends Doctor {
    private int devices;

    @Override
    public int getKnowledge() {
        return super.getKnowledge();
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

    public Tooth delete(Patient patient) {
        return new Tooth();
    }

    public class Tooth {
    }
}

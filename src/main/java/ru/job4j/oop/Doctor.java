package ru.job4j.oop;

import java.util.Date;

public class Doctor extends Profession {
    private int knowledge;

    public int getKnowledge() {
        return knowledge;
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

    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }

    public class Diagnose {
    }

    public class Patient {
    }

}


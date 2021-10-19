package ru.job4j.oop;

import java.util.Date;

public class Surgeon extends Doctor {
    private int expirience;

    public Surgeon(String name, String surname, String education, Date birthday, int knowledge, int expirience) {
        super(name, surname, education, birthday, knowledge);
        this.expirience = expirience;
    }

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

    public Patient operation(Patient patient) {
        return patient;
    }
}

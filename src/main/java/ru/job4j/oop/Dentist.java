package ru.job4j.oop;

import java.util.Date;

public class Dentist extends Doctor {
    private int devices;

    public Dentist(String name, String surname, String education, Date birthday,
                   int knowledge, int devices) {
        super(name, surname, education, birthday, knowledge);
        this.devices = devices;
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

    public Tooth delete(Patient patient) {
        return new Tooth();
    }

}

package ru.job4j.oop;

import java.util.Date;

public class Engineer extends Profession {
    private int iq;

    public Engineer(String name, String surname, String education, Date birthday, int iq) {
        super(name, surname, education, birthday);
        this.iq = iq;
    }

    public int getIq() {
        return iq;
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

    public Idea creation() {
        return new Idea();
    }
}


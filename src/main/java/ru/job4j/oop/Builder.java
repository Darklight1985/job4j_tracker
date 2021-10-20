package ru.job4j.oop;

import java.util.Date;

public class Builder extends Engineer {
    private String instrument;

    public Builder(String name, String surname, String education, Date birthday,
                   int iq, String instrument) {
        super(name, surname, education, birthday, iq);
        this.instrument = instrument;
    }

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

}

package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student vasya = new Student();
        vasya.setFcs("Ivanov Vasilij Ivanich");
        vasya.setGroup(2);
        vasya.setDateReceipt(new Date());
        System.out.println(vasya.getFcs() + " from group "
                + vasya.getGroup() + " : "
                + vasya.getDateReceipt());
    }

}

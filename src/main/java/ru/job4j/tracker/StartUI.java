package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        System.out.println(new Item().getCreated().format(
                DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
    }
}

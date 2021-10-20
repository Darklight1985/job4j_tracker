package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = items[index];
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] withoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                withoutNull[size] = items[index];
                size++;
            }
        }
        withoutNull = Arrays.copyOf(withoutNull, size);
        return withoutNull;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && key.equals(items[index].getName())) {
                rsl[size] = items[index];
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }
}
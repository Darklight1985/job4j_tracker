package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void sortItemAscend() {
        Tracker tracker = new Tracker();
        Item first = new Item("Motata");
        Item second = new Item("Akuna");
        List<Item> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        Collections.sort(items, new SortInAscend());
        assertThat(items.get(0).getName(), is(second.getName()));
    }

    @Test
    public void sortItemDescend() {
        Tracker tracker = new Tracker();
        Item first = new Item("Alphavit");
        Item second = new Item("Zero");
        List<Item> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        Collections.sort(items, new SortInDescend());
        assertThat(items.get(0).getName(), is(second.getName()));
    }
}
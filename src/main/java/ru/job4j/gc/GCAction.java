package ru.job4j.gc;

import ru.job4j.tracker.*;

public class GCAction implements UserAction {
    private final Output out;

    public GCAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Its test GC";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i > -1; i++) {
            String name = new String("testItem");
            Item item = new Item(name);
            tracker.add(item);
        }
        return true;
    }
}
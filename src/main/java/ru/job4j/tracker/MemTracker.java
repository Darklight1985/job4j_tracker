package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {

    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (Item item: items) {
            if (item.getId() == id) {
               rsl = item;
               break;
            }
        }
        return rsl;
    }

    @Override
    public void init() {

    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item: items) {
            if (key.equals(item.getName())) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
          if (items.get(i).getId() == id) {
          index = i;
          break;
     }
 }
 return index;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
       int index = indexOf(id);
       if (index > -1) {
           items.remove(index);
           rsl = true;
       }
        return rsl;

    }

    @Override
    public void close() throws Exception {

    }
}
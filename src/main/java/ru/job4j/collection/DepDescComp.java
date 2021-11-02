package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] str1 = o1.split("/");
        String[] str2 = o2.split("/");
        int rsl = new StringCompare().compare(str2[0], str1[0]);
        if (rsl == 0) {
          rsl = new StringCompare().compare(o1, o2);
        }
        return rsl;
    }
}
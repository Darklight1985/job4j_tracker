package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String s: origin) {
            check.add(s);
        }
        for (String stext: text) {
          if (!check.contains(stext)) {
              rsl = false;
               break;
           }
        }
        return rsl;
    }
}
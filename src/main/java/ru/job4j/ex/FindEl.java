package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
             rsl = index;
             break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("value does not contain key");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = new String[] {"1", "2", "3"};
        try {
            indexOf(value, "4");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
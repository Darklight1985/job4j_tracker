package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FirstStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, -1, 2, 5, 8, 67, -23, 12, -9);
        List<Integer> streamInt = list.stream().filter(s -> s > 0).collect(Collectors.toList());
        streamInt.forEach(System.out::println);
    }
}
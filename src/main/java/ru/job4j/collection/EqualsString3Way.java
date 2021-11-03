package ru.job4j.collection;

import java.util.*;

/**
 * Три способа определить что две строки состоят из одних и тех же символов
 */
public class EqualsString3Way {
    public void firstway(String left, String right) {
        char[] leftCh = left.toCharArray();
        char[] rightcH = right.toCharArray();
        Arrays.sort(leftCh);
        Arrays.sort(rightcH);
        String leftNew = String.valueOf(leftCh);
        String rightNew = String.valueOf(rightcH);
        if (leftNew.equals(rightNew)) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны");
        }
    }

    public void secondWay(String left, String right) {
        char[] leftCh = left.toCharArray();
        char[] rightcH = right.toCharArray();
        Set<Character> symbolsLeft = new TreeSet<>();
        Set<Character> symbolsRight = new TreeSet<>();
        for (char ch: leftCh) {
            symbolsLeft.add(ch);
        }
        for (char ch: rightcH) {
            symbolsRight.add(ch);
        }
        if (symbolsLeft.equals(symbolsRight)) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны");
        }
    }

    public void treesWay(String left, String right) {
        char[] leftCh = left.toCharArray();
        char[] rightcH = right.toCharArray();
        boolean rsl = true;
       List<Character> list = new ArrayList<>();
        for (char ch: leftCh) {
     list.add(ch);
        }
        for (char ch: rightcH) {
            if (!list.contains(ch)) {
                rsl = false;
            }
        }
        if (rsl) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны");
        }
    }
}

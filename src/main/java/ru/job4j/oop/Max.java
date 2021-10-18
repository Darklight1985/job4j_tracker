package ru.job4j.oop;

public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }

    public int max(int first, int second, int third, int four) {
        return max(max(max(first, second), third), four);
    }
}
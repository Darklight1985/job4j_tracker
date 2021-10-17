package ru.job4j.oop;

public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = max(first, second);
        return temp > third ? temp : third;
    }

    public int max(int first, int second, int third, int four) {
        int temp = max(first, second, third);
        return temp > four ? temp : four;
    }
}
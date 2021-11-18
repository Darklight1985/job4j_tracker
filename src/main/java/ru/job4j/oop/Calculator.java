package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public double divide(int y) {
        return y / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double sumAllOperation(int y) {
      return sum(y) + minus(y) + new Calculator().divide(y) + new Calculator().multiply(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);

        System.out.println(calculator.sumAllOperation(2));
        System.out.println(sum(3));
        System.out.println(minus(4));
        System.out.println(calculator.divide(5));
        System.out.println(calculator.multiply(6));
    }
}
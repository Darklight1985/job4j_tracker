package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус ездит по дорогам");
    }

    @Override
    public void passangers(int people) {
        System.out.println("В автобусу " + people + " человек");
    }

    @Override
    public double refuel(int fuel) {
        return 45.4 * fuel;
    }
}

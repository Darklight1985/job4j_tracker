package ru.job4j.oop;

public class PolyTransport {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle autobus = new Autobus();

        Vehicle[] vehicles = new Vehicle[]{plane, train, autobus};
         for (Vehicle vehicle: vehicles) {
             vehicle.move();
         }
    }
}

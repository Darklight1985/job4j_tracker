package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, String message, int status) {
        this.active = active;
        this.message = message;
        this.status = status;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(message);
        System.out.println(status);
    }

    public static void main(String[] args) {
        Error defoltn = new Error();
        Error norm = new Error(true, "не дефолтный конструктор", 666);

        defoltn.printInfo();
        norm.printInfo();
    }
}

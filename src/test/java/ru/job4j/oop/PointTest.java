package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when20to13then3Dot16() {
        double expected = 3.16;
        Point a = new Point(2, 0);
        Point b = new Point(1, 3);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when42to15then2Dot24() {
        double expected = 4.24;
        Point a = new Point(4, 2);
        Point b = new Point(1, 5);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when001to202then2() {
        double expected = 2.24;
        Point a = new Point(0, 0, 1);
        Point b = new Point(2, 0, 2);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when333to421then2Dot24() {
        double expected = 2.45;
        Point a = new Point(3, 3, 3);
        Point b = new Point(4, 2, 1);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
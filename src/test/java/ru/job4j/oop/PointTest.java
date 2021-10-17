package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00to20then2() {
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
}
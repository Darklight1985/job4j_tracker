package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void testMax2Value() {
        int expected = 2;
        Max compare = new Max();
        int res = compare.max(1, 2);
        Assert.assertEquals(expected, res);
    }

    @Test
    public void testMax3Value() {
        int expected = 24;
        Max compare = new Max();
        int res = compare.max(4, 24, 1);
        Assert.assertEquals(expected, res);
    }

    @Test
    public void testMax4Value() {
        int expected = 99;
        Max compare = new Max();
        int res = compare.max(15, 2, 99, 0);
        Assert.assertEquals(expected, res);
    }
}
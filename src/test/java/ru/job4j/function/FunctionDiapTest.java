package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionDiapTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new FunctionDiap().diapasone(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadrFunctionThenLinearResults() {
        List<Double> result = new FunctionDiap().diapasone(2, 7, x -> Math.pow(x, 2) + x);
        List<Double> expected = Arrays.asList(6D, 12D, 20D, 30D, 42D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExpFunctionThenLinearResults() {
        List<Double> result = new FunctionDiap().diapasone(1, 4, x -> Math.pow(3, x) - x);
        List<Double> expected = Arrays.asList(0D, 6D, 24D);
        assertThat(result, is(expected));
    }
}
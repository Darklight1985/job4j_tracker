package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixStreamTest {

    @Test
    public void transform() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3, 4);
        expected.add(list);
        expected.add(list2);
        MatrixStream matrixStream = new MatrixStream();
        List<List<Integer>> rsl = matrixStream.transform(matrix);
        assertThat(expected, is(rsl));
    }
}
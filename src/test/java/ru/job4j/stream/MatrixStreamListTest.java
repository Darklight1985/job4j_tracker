package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixStreamListTest {

    @Test
    public void transform() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        MatrixStreamList matrixStream = new MatrixStreamList();
        List<Integer> rsl = matrixStream.transform(matrix);
        assertThat(expected, is(rsl));
    }

    @Test
    public void transformHard() {
        Integer[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        MatrixStreamList matrixStream = new MatrixStreamList();
        List<Integer> rsl = matrixStream.transform(matrix);
        assertThat(expected, is(rsl));
    }
}
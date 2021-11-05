package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixStream {
    public List<List<Integer>> transform(Integer[][] matrix) {
        List<List<Integer>> list = Stream.of(matrix)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        return list;
    }
}

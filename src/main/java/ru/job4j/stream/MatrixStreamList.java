package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixStreamList {
    public List<Integer> transform(Integer[][] matrix) {
       return Stream.of(matrix)
               .flatMap(e -> new ArrayList<Integer>()
                       .stream())
               .collect(Collectors.toList());
    }
}
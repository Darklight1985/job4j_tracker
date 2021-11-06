package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentMapTest {

    @Test
    public void whenCorrecctMap() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
       StudentMap studentMap = new StudentMap();
        Map<String, Student> rsl = studentMap.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname9", new Student(90, "Surname9"));
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname4", new Student(40, "Surname4"));
        expected.put("Surname5", new Student(50, "Surname5"));
        expected.put("Surname7", new Student(70, "Surname7"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCorrectMapTwo() {
        List<Student> students = List.of(
                new Student(10, "Ivanov"),
                new Student(40, "Pushkin"),
                new Student(50, "Pushkin"),
                new Student(50, "Dulin"),
                new Student(70, "Dulin"),
                new Student(90, "Jmurkin")
        );
        StudentMap studentMap = new StudentMap();
        Map<String, Student> rsl = studentMap.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student(10, "Ivanov"));
        expected.put("Pushkin", new Student(40, "Pushkin"));
        expected.put("Dulin", new Student(50, "Dulin"));
        expected.put("Jmurkin", new Student(90, "Jmurkin"));
        rsl.entrySet().forEach(s -> System.out.println(s));
        assertThat(rsl, is(expected));
    }
}
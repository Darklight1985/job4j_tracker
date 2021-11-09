package ru.job4j.stream;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
       return stream.flatMap(e -> e.getSubjects()
               .stream())
               .mapToInt(Subject::getScore)
               .average()
               .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {

        return List.of(stream
                .map(e -> new Tuple(e.getName(),
                        e.getSubjects()
                                .stream()
                                .mapToDouble(i -> i.getScore())
                                .average()
                                .orElse(0)))
                .collect(Collectors.toList()))
                .stream()
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
                Stream<Subject> subjectStream = stream.flatMap(e -> e.getSubjects()
                        .stream());

        Map<String, Double> map = subjectStream
                .collect(Collectors
                        .groupingBy(Subject::getName, Collectors
                                .averagingDouble(Subject::getScore)));

        return map.entrySet()
                .stream()
                .map(e -> new Tuple(e
                        .getKey(), e
                        .getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(),
                        e.getSubjects()
                                .stream()
                                .mapToDouble(i -> i.getScore()).sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .get();

    }

    public static Tuple bestSubject(Stream<Pupil> stream) {

       return stream
                .flatMap(e -> e.getSubjects()
                .stream())
                .collect(Collectors
                        .groupingBy(Subject::getName, Collectors
                                .summingDouble(Subject::getScore))).entrySet()
                .stream()
                .map(e -> new Tuple(e
                        .getKey(), e
                        .getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore)).get();

    }
}
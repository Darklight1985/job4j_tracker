package ru.job4j.collection;

import java.util.Comparator;

public class SortJobPriorAscend implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getPriority() - second.getPriority();
    }
}

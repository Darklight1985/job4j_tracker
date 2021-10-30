package ru.job4j.collection;

import java.util.Comparator;

public class SortJobPriorDescend implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return second.getPriority() - first.getPriority();
    }
}

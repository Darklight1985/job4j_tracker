package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortInAscend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SortJobTest {

    @Test
    public void sortJobAscendName() {
        Job first = new Job("Engineer", 1);
        Job second = new Job("Boocher", 5);
        int rsl = new SortJobNameAscend().compare(first, second);
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void sortJobDescendName() {
        Job first = new Job("Engineer", 1);
        Job second = new Job("Boocher", 5);
        int rsl = new SortJobNameDescend().compare(first, second);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void sortJobAscendPrior() {
        Job first = new Job("Engineer", 1);
        Job second = new Job("Boocher", 100);
        int rsl = new SortJobPriorAscend().compare(first, second);
        assertThat(rsl, is(-1));
    }

    @Test
    public void sortJobDescendPrior() {
        Job first = new Job("Engineer", 1);
        Job second = new Job("Boocher", 5);
        int rsl = new SortJobPriorDescend().compare(first, second);
        assertThat(rsl, is(1));
    }

        @Test
        public void whenCompatorByNameAndPrority() {
            Comparator<Job> cmpNamePriority = new SortJobNameAscend().
                    thenComparing(new SortJobPriorAscend());
            int rsl = cmpNamePriority.compare(
                    new Job("Doctor", 0),
                    new Job("Doctor", 1)
            );
            assertThat(rsl, lessThan(0));
        }
}
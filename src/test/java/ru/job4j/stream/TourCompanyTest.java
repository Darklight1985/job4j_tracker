package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TourCompanyTest {

    @Test
    public void whenEqualAdress() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Saint-Peterburg", "Kommune", 14, 125)),
                new Profile(new Address("Moscow", "Lenina", 25, 56)),
                new Profile(new Address("Saratov", "Beloostrovskaya", 38, 29)),
                new Profile(new Address("Volgograd", "Esenina", 1, 78))
        );
        TourCompany tourCompany = new TourCompany();
        List<Address> rsl = tourCompany.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Saint-Peterburg", "Kommune", 14, 125));
        expected.add(new Address("Moscow", "Lenina", 25, 56));
        expected.add(new Address("Saratov", "Beloostrovskaya", 38, 29));
        expected.add(new Address("Volgograd", "Esenina", 1, 78));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSizeAdress() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Saint-Peterburg", "Kommune", 14, 125)),
                new Profile(new Address("Moscow", "Lenina", 25, 56)),
                new Profile(new Address("Saratov", "Beloostrovskaya", 38, 29)),
                new Profile(new Address("Volgograd", "Esenina", 1, 78))
        );
        TourCompany tourCompany = new TourCompany();
        List<Address> rsl = tourCompany.collect(profiles);
        assertThat(rsl.size(), is(4));
    }
}
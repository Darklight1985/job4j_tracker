package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TourCompany {
    public List<Address> collect(List<Profile> profiles) {
       return profiles.stream()
               .map(Profile::getAddress)
               .sorted(Address::compareTo)
               .distinct()
               .collect(Collectors.toList());
    }
}

package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class TourCompany {
    public List<Address> collect(List<Profile> profiles) {
       return profiles.stream().map(s -> s.getAddress()).collect(Collectors.toList());
    }
}

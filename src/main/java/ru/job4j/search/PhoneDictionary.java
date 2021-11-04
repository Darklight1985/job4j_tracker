package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> phone = s -> s.getPhone().contains(key);
        Predicate<Person> surName = s -> s.getSurname().contains(key);
        Predicate<Person> adress = s -> s.getAddress().contains(key);
        Predicate<Person> name = s -> s.getName().contains(key);
        Predicate<Person> combine = phone.or(surName.or(adress.or(name)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
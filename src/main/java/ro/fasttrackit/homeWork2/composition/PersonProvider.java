package ro.fasttrackit.homeWork2.composition;

import ro.fasttrackit.homeWork2.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPersons();
}

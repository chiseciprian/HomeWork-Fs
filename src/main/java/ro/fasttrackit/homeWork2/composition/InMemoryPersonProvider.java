package ro.fasttrackit.homeWork2.composition;

import ro.fasttrackit.homeWork2.Person;

import java.util.List;

public class InMemoryPersonProvider implements PersonProvider{
    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("Mihai", "Viteazu",25 )
        );
    }
}

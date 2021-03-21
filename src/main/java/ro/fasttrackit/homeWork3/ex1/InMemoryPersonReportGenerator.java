package ro.fasttrackit.homeWork3.ex1;

import java.util.List;

public class InMemoryPersonReportGenerator extends PersonReportGenerator {
    @Override
    protected List<Person> readPersons() {
        return List.of(
                new Person("Jane",
                        "Doe",
                        91)
        );
    }
}

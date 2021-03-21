package ro.fasttrackit.homeWork3.ex1;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var generator = new FilePersonReportGenerator("src/main/resources/people.txt");
        generator.generateReport("output.txt");
        new InMemoryPersonReportGenerator().generateReport("JaneDoe.txt");
    }

    private static List<Person> providePersons() {
        return List.of(new Person("Ionel", "Popescu", 42));
    }
}

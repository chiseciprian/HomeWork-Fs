package ro.fasttrackit.homeWork2;

import ro.fasttrackit.homeWork2.composition.InMemoryPersonProvider;
import ro.fasttrackit.homeWork2.composition.ReportGenerator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        firstExercises();

        var generator = new FilePersonReportGenerator("src/main/resources/people.txt");
        generator.generateReport("output.txt");
        new InMemoryPersonReportGenerator().generateReport("JaneDoe.txt");
        InMemoryPersonProvider provider = new InMemoryPersonProvider();
        new ReportGenerator(provider).generateReport("mihai.txt");

        new ReportGenerator(Main::providePersons);
    }

    private static List<Person> providePersons() {
        return List.of(new Person("Ionel", "Popescu", 42));
    }

    private static void firstExercises() {
        double mercuryWeight = 0.6;
        double earthWeight = Planet.MERCURY.getWeightOnEarth(mercuryWeight);
        System.out.println(earthWeight);
    }
}

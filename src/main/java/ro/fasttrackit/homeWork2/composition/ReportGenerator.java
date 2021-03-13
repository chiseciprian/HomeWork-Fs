package ro.fasttrackit.homeWork2.composition;

import ro.fasttrackit.homeWork2.AgeFilter;
import ro.fasttrackit.homeWork2.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private final PersonProvider personProvider;

    public ReportGenerator(PersonProvider personProvider) {
        this.personProvider = personProvider;
    }

    public void generateReport(String outputFile) throws IOException {
        List<Person> personList = personProvider.readPersons();
        writeReport(personList, outputFile);
    }

    public void writeReport(List<Person> personList, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            List<Person> personFromFirstTarget = new ArrayList<>();
            List<Person> personFromSecondTarget = new ArrayList<>();
            List<Person> personFromThirdTarget = new ArrayList<>();
            filterByAgeTarget(personList, personFromFirstTarget, personFromSecondTarget, personFromThirdTarget);
            writeFirstTarget(writer, personFromFirstTarget);
            writer.newLine();
            writeSecondTarget(writer, personFromSecondTarget);
            writer.newLine();
            writeThirdTarget(writer, personFromThirdTarget);
        }
    }

    private void writeFirstTarget(BufferedWriter writer, List<Person> personFromFirstTarget) throws IOException {
        writer.write(AgeFilter.FIRST_TARGET.getMinAge() + "-" + AgeFilter.FIRST_TARGET.getMaxAge() + ": ");
        personFromFirstTarget.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName() + ",")
                .forEach(line -> writeLine(writer, line));
    }

    private void writeSecondTarget(BufferedWriter writer, List<Person> personFromFirstTarget) throws IOException {
        writer.write(AgeFilter.SECOND_TARGET.getMinAge() + "-" + AgeFilter.SECOND_TARGET.getMaxAge() + ": ");
        personFromFirstTarget.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName() + ",")
                .forEach(line -> writeLine(writer, line));
    }

    private void writeThirdTarget(BufferedWriter writer, List<Person> personFromFirstTarget) throws IOException {
        writer.write(AgeFilter.THIRD_TARGET.getMinAge() + "+: ");
        personFromFirstTarget.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName() + ",")
                .forEach(line -> writeLine(writer, line));
    }

    private void filterByAgeTarget(List<Person> personList, List<Person> personFromFirstTarget, List<Person> personFromSecondTarget, List<Person> personFromThirdTarget) {
        personList.forEach(person -> {
            int age = person.getAge();
            if (age >= AgeFilter.FIRST_TARGET.getMinAge() && age <= AgeFilter.FIRST_TARGET.getMaxAge()) {
                personFromFirstTarget.add(person);
            } else if (age >= AgeFilter.SECOND_TARGET.getMinAge() && age <= AgeFilter.SECOND_TARGET.getMaxAge()) {
                personFromSecondTarget.add(person);
            } else {
                personFromThirdTarget.add(person);
            }
        });
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

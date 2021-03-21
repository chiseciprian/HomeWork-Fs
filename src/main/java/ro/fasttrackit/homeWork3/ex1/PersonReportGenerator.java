package ro.fasttrackit.homeWork3.ex1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class PersonReportGenerator {

    public void generateReport(String outputFile) throws IOException {
        List<Person> personList = readPersons();
        Map<AgeFilter, List<Person>> personGrouped = personList.stream()
                .collect(Collectors.groupingBy(Person::getAgeFilter));
        writeReport(personGrouped, outputFile);
    }

    private void writeReport(Map<AgeFilter, List<Person>> persons, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            persons.forEach((ageFilter, peoples) -> {
                try {
                    printByAge(writer, peoples, ageFilter.getMinAge(), ageFilter.getMaxAge());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void printByAge(BufferedWriter writer, List<Person> person, int minAge, int maxAge) throws IOException {
        writeInLine(writer, minAge + "-" + maxAge + ": ");
        person.stream()
                .filter(people -> people.getAge() > minAge && people.getAge() <= maxAge)
                .map(people -> people.getFirstName() + " " + people.getLastName() + ",")
                .forEach(line -> writeInLine(writer, line));
        writer.newLine();
    }

    private void writeInLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<Person> readPersons();
}

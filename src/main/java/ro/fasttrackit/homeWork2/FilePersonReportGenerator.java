package ro.fasttrackit.homeWork2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilePersonReportGenerator extends PersonReportGenerator {

    private final String sourceFile;

    public FilePersonReportGenerator(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    protected List<Person> readPersons() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::readCountry)
                    .collect(toList());
        } catch (IOException e) {
            System.err.println("Could not read from file " + sourceFile);
        }
        return List.of();
    }

    private Person readCountry(String line) {
        String[] personInfo = line.split(",");
        return new Person(
                personInfo[0],
                personInfo[1],
                Integer.parseInt(personInfo[2])
        );
    }
}

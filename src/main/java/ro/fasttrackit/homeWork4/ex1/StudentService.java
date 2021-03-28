package ro.fasttrackit.homeWork4.ex1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StudentService {
    private List<Student> students;

    public StudentService(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public String averageStudentsGrades() {
        return students.stream()
                .collect(Collectors.teeing(
                        mapping(student -> student.name() + ", ", joining()),
                        averagingInt(Student::grades),
                        (names, average) -> names + " have an average grade of " + average
                ));
    }

    public List<String> getStudentsCourse() {
        return students.stream()
                .map(student -> student.name() + " will participate to course " + getRandomCourse())
                .collect(Collectors.toList());
    }

    public String getStudentPlace(Student student) {
        return switch (students.indexOf(student)) {
            case 0, 1, 2 -> "1st grade";
            case 3 -> "5th grade";
            default -> "7th grade";
        };
    }

    private String getRandomCourse() {
        String course1 = """
                    {
                        "course":"%s",
                        "semester": %d    
                    }
                """.formatted("Math 101", 2);
        String course2 = """
                    {
                        "course":"%s",
                        "semester": %d    
                    }
                """.formatted("Romanian", 1);
        String course3 = """
                    {
                        "course":"%s",
                        "semester": %d    
                    }
                """.formatted("Biology", 2);
        List<String> courses = List.of(course1, course2, course3);
        return courses.get(new Random().nextInt(courses.size()));
    }
}

record Student(String name, LocalDate birthDate, int grades) {
    public Student(String name, int age, int grades) {
        this(name, setRandomBirthday(age), grades);
    }

    private static LocalDate setRandomBirthday(int age) {
        Random random = new Random();
        return LocalDate.now().minusYears(age).withMonth(random.nextInt(12) + 1).withDayOfMonth(random.nextInt(28) + 1);
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}



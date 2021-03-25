package ro.fasttrackit.homeWork4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentService {
    private List<Main.Student> students;

    public StudentService(List<Main.Student> students) {
        this.students = new ArrayList<>(students);
    }

    public String averageStudentsGrades() {
        return students.stream()
                .collect(Collectors.teeing(
                        Collectors.mapping(Main.Student::name, Collectors.toList()),
                        Collectors.averagingInt(Main.Student::grades),
                        (names, average) -> names + " have an average grade of " + average
                ));
    }

    public List<String> getStudentsCourse() {
        return students.stream()
                .map(student -> student.name() + " will participate to course " + getRandomCourse())
                .collect(Collectors.toList());
    }

    public String getStudentPlace(Main.Student student) {
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



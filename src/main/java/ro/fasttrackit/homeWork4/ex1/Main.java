package ro.fasttrackit.homeWork4.ex1;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Student("Ana", LocalDate.of(1999, 12, 1), 8));
        System.out.println(new Student("Mircea", 21, 10));

        Student student1 = new Student("Cipri", LocalDate.of(1999, 12, 1), 8);
        Student student2 = new Student("Mircea", 21, 10);
        Student student3 = new Student("Steli", 21, 10);
        Student student4 = new Student("Alex", 21, 10);
        Student student5 = new Student("Dmitry", 21, 10);
        StudentService studentService = new StudentService(List.of(student1, student2, student3, student4, student5));

        System.out.println(studentService.averageStudentsGrades());
        System.out.println(studentService.getStudentsCourse());

        System.out.println(studentService.getStudentPlace(student1));
        System.out.println(studentService.getStudentPlace(student2));
        System.out.println(studentService.getStudentPlace(student3));
        System.out.println(studentService.getStudentPlace(student4));
        System.out.println(studentService.getStudentPlace(student5));
    }
}

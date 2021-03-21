package ro.fasttrackit.homeWork3.ex1;

import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final AgeFilter ageFilter;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ageFilter = setAgeFilter(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public AgeFilter getAgeFilter() {
        return ageFilter;
    }

    private AgeFilter setAgeFilter(int age) {
        if (age > AgeFilter.FIRST_TARGET.getMinAge() && age <= AgeFilter.FIRST_TARGET.getMaxAge()) {
            return AgeFilter.FIRST_TARGET;
        } else if (age > AgeFilter.SECOND_TARGET.getMinAge() && age <= AgeFilter.SECOND_TARGET.getMaxAge()) {
            return AgeFilter.SECOND_TARGET;
        } else {
            return AgeFilter.THIRD_TARGET;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

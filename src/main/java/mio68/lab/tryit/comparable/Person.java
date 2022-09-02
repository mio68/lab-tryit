package mio68.lab.tryit.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;


    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("John", "Doe"),
            new Person("Verner", "Brown"),
            new Person("Luke", "Brown"),
            new Person("Luke", "Skywalker"),
            new Person("Darth", "Vader"),
            new Person("Joe", "Vader")
        );

        persons.sort(Comparator.comparing(Person::getLastName)
                                .thenComparing(Person::getFirstName));

        persons.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}

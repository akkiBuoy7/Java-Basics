package functional.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static functional.imperative.Main.Gender.FEMALE;
import static functional.imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Akash", MALE),
                new Person("Priya", FEMALE),
                new Person("Kohli", MALE),
                new Person("Sania", FEMALE)
        );

        // Imperative Approach
        /*
        Here we explicitly declared everything and wrote boiler code.
         */
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }

        System.out.println("Imperative Approach--->\n");
        for (Person female : females) {
            System.out.print(female + " ");
        }

        System.out.println("\n");

        System.out.println("Declarative Approach--->\n");
        // Declarative Approach
        List<Person> females2 = people.stream()
                .filter(person -> person.gender.equals(MALE))
                .collect(Collectors.toList());
        females2.forEach(System.out::print);
    }

    enum Gender {
        MALE, FEMALE
    }

    static class Person {
        final private String name;
        final private Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}

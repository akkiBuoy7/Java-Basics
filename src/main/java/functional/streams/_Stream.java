package functional.streams;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static functional.streams._Stream.Gender.FEMALE;
import static functional.streams._Stream.Gender.MALE;

public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Akash", MALE),
                new Person("Priya", FEMALE),
                new Person("Kohli", MALE),
                new Person("Sania", FEMALE)
        );

        people.stream()
                .map(obj -> obj.gender)// It takes a Function
                .collect(Collectors.toSet())
                .forEach(System.out::println); // It takes a Consumer


        // using separate functions
        final Function<Person, Gender> personGenderFunction = obj -> obj.gender;
        final Collector<Gender, ?, Set<Gender>> genderSetCollector = Collectors.toSet();
        Consumer<Gender> println = System.out::println;

        people.stream()
                .map(personGenderFunction)// It takes a Function
                .collect(genderSetCollector)
                .forEach(println); // It takes a Consumer

        people.stream()
                .allMatch(obj -> obj.gender.equals(FEMALE)); //It takes a predicate

        // using separate functions
        Predicate<Person> personPredicate = obj -> obj.gender.equals(FEMALE);
        boolean isFemaleOnly = people.stream()
                .allMatch(personPredicate); //It takes a predicate
        System.out.println(isFemaleOnly);

        Optional<String> hello = Optional.of("Hello");
        hello.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Value is null"));

        // using separate functions
        Optional<String> hello1 = Optional.of("Hello");
        Consumer<String> println1 = System.out::println;
        Runnable value_is_null = () -> System.out.println("Value is null");
        hello1.ifPresentOrElse(println1, //It takes a consumer and a Runnable
                value_is_null);

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

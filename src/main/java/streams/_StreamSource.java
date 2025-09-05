package streams;


import java.util.Arrays;
import java.util.stream.Stream;

import static streams.Gender.MALE;

public class _StreamSource {

    public static void main(String[] args) {

        Stream.Builder<Person> builder = Stream.builder(); // using builder
        builder.add(new Person("Akash",30,MALE));
        builder.add(new Person("Akki",31,MALE));

        Stream<Person> stream = builder.build();
        stream.forEach(obj -> System.out.println(obj.toString()));


        Stream<Person> pojoStream = Stream.
                of(new Person("Akash", 30,MALE), new Person("Akki", 31,MALE)); // using stream
        pojoStream.forEach(obj -> System.out.println(obj.toString()));

        Stream<Person> streamArray = Arrays // using arrays
                .stream(new Person[]{new Person("Akash", 30,MALE),
                        new Person("Akki", 31,MALE)});
        streamArray.forEach(System.out::println); // method reference
    }
}

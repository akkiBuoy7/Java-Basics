package functional.optionals;

import java.util.Optional;

public class Main {
    /*
    Java 8 introduced the Optional class in the java.util package to handle the problem of null values more gracefully.
    Instead of risking NullPointerException (NPE), Optional provides a container object that may or may not hold a non-null value.
     */

    /*
    Optional.ofNullable -> to declare a null safe variable

     */
    public static void main(String[] args) {

        Optional<Object> empty = Optional.empty();
        // checks if value is present
        System.out.println(empty.isPresent());
        // checks if object is empty
        System.out.println(empty.isEmpty());

        Optional<Object> notEmpty = Optional.of("Hello");
        System.out.println(notEmpty.isPresent());
        System.out.println(notEmpty.isEmpty());

        /*when we are not sure about object being null we use ofNullable
        Using this we can use a fallBack value
        */
        Optional<String> objectOptional = Optional.ofNullable(null);
        String o = objectOptional.orElse("Hello!"); // if objectOptional is null it will print hello
        System.out.println(o);


        /* Mapping an optional object */
        String s = Optional.ofNullable("akash").
                map(String::toUpperCase)
                .orElse("null value");
        System.out.println(s);

        /*
        Behaves like a let of kotlin
         */
        Optional<Object> o1 = Optional.ofNullable(null);
        o1.ifPresent(v -> {
            System.out.println(o); // will not enter here since o1 is null
        });

        /*
        Using a fallback value
         */
        o1.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Value is null")); // o1 is null so this line will execute


        Person p =  new Person("Akash",null);
        System.out.println(p.getEmail().map(String::toLowerCase).orElse("Email is empty"));

        Person p1 =  new Person("Akash","akash@gmail.com");

        if (p1.getEmail().isPresent()){
            System.out.println(p1.getEmail().map(String::toLowerCase).get());
        }else {
            System.out.println("Email is empty");
        }
    }

    static class Person{
        final private String name;
        final private String email;

        Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
}

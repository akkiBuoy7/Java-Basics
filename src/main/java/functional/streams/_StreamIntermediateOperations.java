package functional.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static functional.streams.Gender.FEMALE;
import static functional.streams.Gender.MALE;

public class _StreamIntermediateOperations {

    public static void main(String[] args) {

        //************Filter******************
        ArrayList<Person> objList = new ArrayList<Person>(Arrays.asList(new Person("Akash", 30, MALE),
                new Person("Akki", 31,MALE), new Person("Priya", 50,FEMALE), new Person("Puja",
                        41,FEMALE)));

        List<Person> filteredList = objList.stream().filter(obj -> obj.getAge() % 2 == 0)
                .collect(Collectors.toList());

        filteredList.forEach(System.out::println);

        System.out.println("***********************\n");

        // using Predicate for filter
        Predicate<Person> pojoPredicate = obj -> obj.getAge() % 2 == 0;
        List<Person> filteredListPredicate = objList.stream().filter(pojoPredicate)
                .collect(Collectors.toList());

        //*************Map**************************

        List<Person> mappedList = objList.stream()
                .map(obj -> new Person(obj.getName(), obj.getAge() * 2,obj.getGender()))
                .collect(Collectors.toList());

        mappedList.forEach(System.out::println);
        System.out.println("***********************\n");

        // using Function for map
        Function<Person, Person> pojoPojoFunction = obj ->new Person(obj.getName(),
                obj.getAge() * 2,obj.getGender());
        List<Person> mappedListFunction = objList.stream()
                .map(pojoPojoFunction)
                .collect(Collectors.toList());

        //*********************Filter and Map**********************
        // filter and map
        List<Person> filteredMappedList =
                objList.stream().filter(obj -> obj.getAge() % 2 == 0).map( obj1 -> new Person(obj1.getName(),
                        obj1.getAge() * 2,obj1.getGender()))
                .collect(Collectors.toList());
        filteredMappedList.forEach(System.out::println);
        System.out.println("***********************\n");

        //*********************Peek**********************
        // filter and map
        List<Person> filteredMappedPeekList =
                objList.stream().filter(obj -> obj.getAge() % 2 == 0).map( obj1 -> new Person(obj1.getName(),
                        obj1.getAge() * 2,obj1.getGender())).
                        peek(obj->System.out.println("peeked" + obj.toString()))
                        .collect(Collectors.toList());
        filteredMappedPeekList.forEach(System.out::println);
        System.out.println("***********************\n");

        //***********************Limit*************************

        List<Person> limitList = objList.stream().limit(2).collect(Collectors.toList());
        limitList.forEach(System.out::println);
        System.out.println("***********************\n");

        //**********************Skip****************************

        List<Person> skipList = objList.stream().skip(2).collect(Collectors.toList());
        skipList.forEach(System.out::println);
        System.out.println("***********************\n");

        //************************FlatMap**************************

        List<Person> list1 = Arrays.asList(new Person("Akash", 30,MALE), new Person("Akki", 31,
                MALE));
        List<Person> list2 = Arrays.asList( new Person("Priya", 50,FEMALE), new Person("Puja", 41
                ,FEMALE));
        List<List<Person>> listOfLists = Arrays.asList(list1, list2);

        List<Person> flatMapList = listOfLists.stream().flatMap(stream -> stream.stream())
                .collect(Collectors.toList());
        flatMapList.forEach(System.out::println);

        // using function for flatMap
        Function<List<Person>, Stream<? extends Person>> listStreamFunction = Collection::stream;
        List<Person> flatMapListFunction = listOfLists.stream().flatMap(listStreamFunction)
                .collect(Collectors.toList());

        System.out.println("***********************\n");

        //*************************distinct******************************

        List<Person> listDis = Arrays.asList(new Person("Akash", 30,MALE), new Person("Akki", 31, MALE),
                new Person("Akash", 30,MALE), new Person("Akki", 31,MALE));


        List<String> distinctList =
                listDis.stream().map(Person::getName).distinct().collect(Collectors.toList());
        distinctList.forEach(System.out::println);
        System.out.println("***********************\n");

        //****************************sorted*********************************
        ArrayList<Person> objList1 = new ArrayList<>(Arrays.asList(new Person("Akash", 30,MALE),
                new Person("Akki", 31,MALE), new Person("Priya", 50,FEMALE), new Person("Puja", 41,
                        FEMALE)));


        List<Person> sortedList = objList1.stream().sorted(Comparator.comparing(obj -> obj.getAge()))
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);


        // using comparator for sorted
        Comparator<Person> comparing = Comparator.comparing(obj -> obj.getAge());
        List<Person> sortedListComparator = objList1.stream().sorted(comparing)
                .collect(Collectors.toList());

        System.out.println("***********************\n");
    }
}

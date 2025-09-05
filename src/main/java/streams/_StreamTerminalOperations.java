package streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams.Gender.FEMALE;
import static streams.Gender.MALE;

public class _StreamTerminalOperations {
    public static void main(String[] args) {

        ArrayList<Person> objList = new ArrayList<>(Arrays.asList(new Person("Akash", 30, MALE),
                new Person("Akki", 31,MALE), new Person("Priya", 50,FEMALE), new Person("Puja",
                        41,FEMALE)));

        //************************allMatch*******************
        if (objList.stream().allMatch(person->person.getAge()>40)){
            System.out.println("All have age greater than 40");
        }else {
            System.out.println("All don't have age greater than 40");
        }

        // using predicate for allMatch
        Predicate<Person> personPredicate = person -> person.getAge() > 40;
        objList.stream().allMatch(personPredicate);
        System.out.println("***********************\n");

        //****************************anyMatch********************
        if (objList.stream().anyMatch(person->person.getAge()>40)){
            System.out.println("Atleast one have age more than 40");
        }else {
            System.out.println("No one have age greater than 40");
        }
        System.out.println("***********************\n");

        //**********************noneMatch*****************************
        if (objList.stream().noneMatch(person->person.getName().equals("Akash"))){
            System.out.println("No one have name as Akash");
        }else {
            System.out.println("Atleast one have name as Akash");
        }
        System.out.println("***********************\n");

        //******************************max***********************

        objList.stream().max(Comparator.comparing(Person::getAge)).
                ifPresentOrElse( // max and min returns an Optional object
                obj-> System.out.println("Person with maximum age> "+obj.getName()),
                ()->{ System.out.println("Age Not present");
                });
        System.out.println("***********************\n");

        //******************************min***********************

        objList.stream().min(Comparator.comparing(Person::getAge)).
                ifPresentOrElse( // max and min returns an Optional object
                        obj-> System.out.println("Person with minimum age> "+obj.getName()),
                        ()->{ System.out.println("Age Not present");
                        });
        System.out.println("***********************\n");

        //**********************groupBy***********************

        Map<Gender, List<Person>> genderListMap = objList.stream()
                .collect(Collectors.
                        groupingBy(Person::getGender));//It returns a Map with key asthe groupBy criteria

        List<Person> maleList = new ArrayList<>();
        List<Person> femaleList = new ArrayList<>();

        genderListMap.forEach((gender,person) ->{

            if (gender.equals(MALE)){
                maleList.addAll(person);
            }else {
                femaleList.addAll(person);
            }
        });
        System.out.println(maleList);
        System.out.println();
        System.out.println(femaleList);

        System.out.println("***********************\n");

        //**********************count***********************
        System.out.println(maleList.stream().count());
    }
}

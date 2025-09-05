package functionalinterface;

import java.util.function.Predicate;

/*
 * Predicate can return boolean only
 * Predicate<Argument>
 -->and(Predicate)-->or(Predicate)-->test()
 */
public class _Predicate {
    public static void main(String[] args) {

        System.out.println(isNumberValid("91021201"));

        // calling Predicate
        System.out.println(isNumberValidPredicate.test("9102120100"));

        // false and false will return false
        System.out.println("Is phone number valid and contains 3 "+isNumberValidPredicate.and(contains3).test("912036897"));

        // true and false will return false
        System.out.println("Is phone number valid and contains 3 "+isNumberValidPredicate.and(contains3).test("9120668971"));

        // true and true will return true
        System.out.println("Is phone number valid and contains 3 "+isNumberValidPredicate.and(contains3).test("9130668971"));

        // true or false will return true
        System.out.println("Is phone number valid or contains 3 "+isNumberValidPredicate.or(contains3).test("9120668971"));

    }

    static boolean isNumberValid(String number) {
        return number.startsWith("91") && number.length() == 10;
    }

    /* Accepts a argument but return type is boolean */
    static Predicate<String> isNumberValidPredicate = number -> number.startsWith("91") && number.length() == 10;

    static Predicate<String> contains3 = number -> number.contains("3");
}

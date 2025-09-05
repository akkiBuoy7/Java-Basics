package callbacks;

import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {

    // Higher order Function ->> passing a lambda function (with param but no return type) as
    // function  parameter
    public static void checkNull(Customer customer, Consumer<Customer> callback) {
        if (customer.number != null) {
            System.out.println(customer.customer);
        } else {
            Customer c = new Customer("Akash", "no was null");
            callback.accept(c); // invoking the callback lambda function
        }
    }


    // Higher order Function ->> passing a lambda function (with no param or return type) as
    // function parameter
    public static void checkNull2(Customer customer, Runnable callback) {
        if (customer.number != null) {
            System.out.println(customer.customer);
        } else {
            callback.run(); // invoking the callback lambda function
        }
    }

    // Higher order Function ->> passing a lambda function (with param and return type) as
    // function  parameter
    public static void checkNull3(Customer customer, Function<Customer,String> callback) {
        if (customer.number != null) {
            System.out.println(customer.customer);
        } else {
            String apply = callback.apply(customer);// invoking the callback lambda function
            System.out.println(apply);
        }
    }

    public static void main(String[] args) {

        // lambda function of Consumer type
        Consumer<Customer> greetCustomerConsumer =
                customer -> System.out.println(
                        "Hello " + customer.customer + " having ph number " + customer.number);

        greetCustomerConsumer.accept(new Customer("Akash", "123"));


        // using call back
        // Higher order Function ->> passing a lambda function as function parameter
        checkNull(new Customer("Akash", null),
                customer -> { System.out.println("number >>> " + customer.number);});


        // using call back
        // Higher order Function ->> passing a lambda function (having an argument) as function
        // parameter
        checkNull2(new Customer("Akash", null),
                () -> { System.out.println("do something");
        });

        // using call back
        // Higher order Function ->> passing a lambda function (having an argument) as function
        // parameter
        checkNull3(new Customer("Akki", null),
                (customer) -> { return ""+customer.customer; });


        // Higher order Function ->> passing a lambda function(having no argument or return type)
        // as
        // return type
        String akki_higher_order = CallBackInterface.higherOrder().apply(
                new Customer("Akki_Higher_Order", "123")
        );
        System.out.println(akki_higher_order);

    }


    interface CallBackInterface extends Function<Customer,String>{

        // Higher order Function ->> passing a lambda function as return type
        static CallBackInterface higherOrder(){
            return customer -> "customer name "+customer.customer;
        }
    }

    static class Customer {

        private final String customer;
        private final String number;

        public Customer(String customer, String number) {
            this.customer = customer;
            this.number = number;
        }
    }
}

package functional.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
 * Consumer can return a function body i.e Unit type
 * Consumer<Argument>
 -->accept()
 */

public class _Consumer {
    /* Consumer takes an argument
    and returns
    nothing but a function body*/
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println
            ("Hello " + customer.customer + " having ph number " + customer.number);

    /* BiConsumer takes two arguments
    and returns
    nothing but a function body*/
    static BiConsumer<Customer,Boolean> greetCustomerBiConsumer = (customer,showNumber) -> System.out.println
            ("Hello " + customer.customer + " having ph number " + (showNumber ? customer.number : "*******"));

    public static void main(String[] args) {

        greetCustomer(new Customer("Akash", "7005161586"));
        greetCustomerConsumer.accept(new Customer("Akash_consumer", "7005161586"));
        greetCustomerBiConsumer.accept(new Customer("Akash_consumer", "7005161586"),false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customer + " having ph number " + customer.number);
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

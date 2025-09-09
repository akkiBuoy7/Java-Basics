package functional.callbacks;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface ConsumerInterface extends Consumer<Customer> {
    ConsumerInterface higherOrderConsumer = (cus) ->
            System.out.println(cus.id + ".This is " + cus.name + " interface callback");

    static ConsumerInterface higherOrderConsumerF() {
        return (cus) -> {
            System.out.println(cus.id + ".This is " + cus.name + " interface callback");
        };
    }
}

interface SupplierInterface extends Supplier<Customer> {
    SupplierInterface higherOrderSupplier = () -> new Customer("Supplier", 2);

    static SupplierInterface higherOrderSupplierF() {
        return () ->
                new Customer("SupplierF", 2);

    }
}

interface FunctionInterface extends Function<Customer, String> {
    FunctionInterface higherOrderFunction = (cus) ->
            cus.id + ".This is " + cus.name + " interface callback";

    static FunctionInterface getHigherOrderFunctionF() {
        return (cus) -> cus.id + ".This is " + cus.name + " interface callback";
    }
}

interface PredicateInterface extends Predicate<Customer> {
    PredicateInterface higherOrderPredicate = (cus) -> cus.id % 2 == 0;

    static PredicateInterface higherOrderPredicateF() {
        return (cus) -> cus.id % 2 == 0;
    }
}

class Customer {
    String name;
    int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}' + "\n";
    }
}

public class InterfaceCallbacks {
    public static void main(String[] args) {
        ConsumerInterface.higherOrderConsumer.accept(new Customer("Consumer", 1));
        ConsumerInterface.higherOrderConsumerF().accept(new Customer("ConsumerF", 1));

        Customer cus = SupplierInterface.higherOrderSupplier.get();
        System.out.println(cus.id + ".This is " + cus.name + " interface callback");

        Customer cus1 = SupplierInterface.higherOrderSupplierF().get();
        System.out.println(cus1.id + ".This is " + cus1.name + " interface callback");

        String function = FunctionInterface.higherOrderFunction.apply(new Customer("Function", 3));
        System.out.println(function);

        String functionF = FunctionInterface.getHigherOrderFunctionF()
                .apply(new Customer("FunctionF",
                        3));
        System.out.println(functionF);

        Boolean isEvenId = PredicateInterface.higherOrderPredicate.test(new Customer("Predicate",
                4));
        System.out.println(isEvenId);
        Boolean isEvenIdF = PredicateInterface.higherOrderPredicateF()
                .test(new Customer("Predicate",
                        5));
        System.out.println(isEvenIdF);
    }
}

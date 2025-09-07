package basics.variable.oops;


abstract class WildAnimal {
    abstract void makeSound();

    void sleep() {
        System.out.println("Sleeping : Zzz");
    }
}

class Dog extends WildAnimal {

    @Override
    void makeSound() {
        System.out.println("Dog is barking");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        /*
        Abstract class can not be instantiated
         */
        //WildAnimal wildAnimal = new WildAnimal();

        // Anonymous class syntax for abstract class object creation.
        WildAnimal wildAnimal = new WildAnimal() {
            @Override
            void makeSound() {
                System.out.println("Wild animals make sound");
            }
        };
        wildAnimal.makeSound();

        System.out.println();
        Dog dog = new Dog();
        dog.makeSound(); // accessing the abstract method
        dog.sleep(); // accessing the concrete method
    }
}

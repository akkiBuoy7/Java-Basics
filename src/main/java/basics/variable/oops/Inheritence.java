package basics.variable.oops;

class Animal {
    void isCarnivore(){
        System.out.println("Animal may be carnivore");
    };
    void eats(){
        System.out.println("Animal eats");
    }
}


class Tiger extends Animal{

    @Override
    void eats() {
        super.eats(); // calling parent method
        System.out.println("Tiger eats");
    }

    @Override
    void isCarnivore() {
        System.out.println("Tiger must be carnivore");
    }
}

class Cow extends Animal{
    @Override
    void eats() {
        System.out.println("cow eats");
    }
}

public class Inheritence {
    public static void main(String[] args) {
        // compile time polymorphism
        System.out.println("compile time polymorphism");
        Tiger tiger = new Tiger();
        tiger.eats();
        tiger.isCarnivore();


        // Dynamic method dispatch or runtime polymorphism
        System.out.println("Runtime polymorphism");
        Animal animal = new Cow();
        /*
        Even though ref variable is Animal , but child cow object will execute eat method
         */
        animal.eats();
        /*
        since child has not overridden this method , so parent method will execute
         */
        animal.isCarnivore();
    }
}
package basics.variable.oops;


class MainClass {
    public MainClass() {
        System.out.println("This is first constructor of main class");
    }

    public MainClass(String s) {
        System.out.println("This is " + s + "constructor of main class");
    }

    public MainClass(int s) {
        this(); // calling the first constructor
        System.out.println("This is " + s + "rd constructor of main class");
    }
}

class ChildClass extends MainClass {
    public ChildClass() {
        System.out.println("This is first constructor of child class");
    }

    public ChildClass(String s) {
        super(s);
        System.out.println("This is " + s + "constructor of child class");
    }
}

public class Constructors {

    public static void main(String[] args) {
        /*
        Even though child class object is created , but the parent class constructor will also
        get called by default.
         */
        ChildClass c = new ChildClass();
        System.out.println("Super");
        /*
        We can control which constructor of main class will be called by using super keyword.
         */
        ChildClass c1 = new ChildClass("Second");

        System.out.println("This");
        /*
        Constructor chaining done by calling 1st constructor in 3rd constructor
         */
        MainClass m = new MainClass(3);
    }
}

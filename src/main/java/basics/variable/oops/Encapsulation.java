package basics.variable.oops;

public class Encapsulation {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Akash";
        System.out.println("name is " + p.name);
        // p.age= 2 not possible to access private variable
        /*
        Use getter and setter to modify the encapsulated variable
         */
        p.set(33);
        System.out.println("age is "+p.getAge());
    }
}

class Person {

    public String name;
    private int age; // restricted access

    public void set(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }
}

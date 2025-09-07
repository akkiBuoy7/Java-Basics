package basics.variable.collectionFramework;

import java.util.*;

public class DemoObject {
    private String name;
    private int age;
    private Character gender;

    public DemoObject(String n, int a, Character g) {
        this.name = n;
        this.age = a;
        this.gender = g;
    }

    public DemoObject() {}

    public ArrayList<DemoObject> returnArrayList() {
        ArrayList<DemoObject> arrayList = new ArrayList<DemoObject>();
        arrayList.add(new DemoObject("Akash", 33, 'M'));
        arrayList.add(new DemoObject("Rohan", 28, 'M'));
        arrayList.add(new DemoObject("Dibakar", 36, 'M'));
        arrayList.add(new DemoObject("Palash", 33, 'M'));
        arrayList.add(new DemoObject("Rimi", 27, 'F'));
        arrayList.add(new DemoObject("Mumpa", 38, 'F'));
        return arrayList;
    }

    public LinkedList<DemoObject> returnLinkedList() {
        LinkedList<DemoObject> linkedList = new LinkedList<DemoObject>();
        linkedList.add(new DemoObject("Akash", 33, 'M'));
        linkedList.add(new DemoObject("Rohan", 28, 'M'));
        linkedList.add(new DemoObject("Dibakar", 36, 'M'));
        linkedList.add(new DemoObject("Palash", 33, 'M'));
        linkedList.add(new DemoObject("Rimi", 27, 'F'));
        linkedList.add(new DemoObject("Mumpa", 38, 'F'));
        return linkedList;
    }

    public Queue<DemoObject> returnDequeueList() {
        Queue<DemoObject> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(new DemoObject("Akash", 33, 'M'));
        arrayDeque.add(new DemoObject("Rohan", 28, 'M'));
        arrayDeque.add(new DemoObject("Dibakar", 36, 'M'));
        arrayDeque.add(new DemoObject("Palash", 33, 'M'));
        arrayDeque.add(new DemoObject("Rimi", 27, 'F'));
        arrayDeque.add(new DemoObject("Mumpa", 38, 'F'));
        return arrayDeque;
    }

    public Stack<DemoObject> returnStack() {
        Stack<DemoObject> stack = new Stack<DemoObject>();
        stack.add(new DemoObject("Akash", 33, 'M'));
        stack.add(new DemoObject("Rohan", 28, 'M'));
        stack.add(new DemoObject("Dibakar", 36, 'M'));
        stack.add(new DemoObject("Palash", 33, 'M'));
        stack.add(new DemoObject("Rimi", 27, 'F'));
        stack.add(new DemoObject("Mumpa", 38, 'F'));
        return stack;
    }

    public PriorityQueue<DemoObject> returnPriorityQueue() {
        PriorityQueue<DemoObject> priorityQueue = new PriorityQueue<DemoObject>();
        priorityQueue.add(new DemoObject("Akash", 33, 'M'));
        priorityQueue.add(new DemoObject("Rohan", 28, 'M'));
        priorityQueue.add(new DemoObject("Dibakar", 36, 'M'));
        priorityQueue.add(new DemoObject("Palash", 33, 'M'));
        priorityQueue.add(new DemoObject("Rimi", 27, 'F'));
        priorityQueue.add(new DemoObject("Mumpa", 38, 'F'));
        return priorityQueue;
    }


    /*
     Defines how two objects are considered "equal" in terms of their content, not their memory
     address.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DemoObject)) return false;
        DemoObject demo = (DemoObject) o;
        return age == demo.age &&
                Objects.equals(name, demo.name) &&
                Objects.equals(gender, demo.gender);
    }

    /*
    Provides a hash code that’s consistent with equals(). It's required especially when your object
     is used in hash-based collections like HashMap, HashSet, etc.
     */

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    public String toString() {
        return "(\"" + name + "\", " + age + ", \"" + gender + "\")";
    }
}

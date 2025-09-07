package basics.variable.collectionFramework.list;

import basics.variable.collectionFramework.CollectionFrameworkInterface;
import basics.variable.collectionFramework.DemoObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class ListInterface extends CollectionFrameworkInterface {
}

class ArrayListClass extends ListInterface {

    public static void main(String[] args) {

        ArrayList<Integer> myArrayList1 = new ArrayList<>();
        ArrayList<DemoObject> myArrayListObj = new DemoObject().returnArrayList();


        // ***************** Collection Framework Methods *******************************

        /*
        // add
        myArrayList1.add(100);
        myArrayList1.add(200);
        myArrayList1.add(300);
        myArrayList1.add(400);
        myArrayList1.add(500);


        System.out.println("add : -> " + myArrayList1);
        System.out.println("add : -> " + myArrayListObj);
        // remove index
        myArrayList1.remove(1);
        myArrayListObj.remove(1);
        System.out.println("remove index : -> " + myArrayList1);
        System.out.println("Demo remove index : -> " + myArrayListObj);
        // remove object
        myArrayList1.remove(Integer.valueOf(400));
        DemoObject d1 = new DemoObject("Akash", 33, 'M');
        myArrayListObj.remove(d1);
        System.out.println("remove object : -> " + myArrayList1);
        System.out.println("Demo remove object : -> " + myArrayListObj.toString());
        // Add all
        ArrayList<Integer> myArrayList2 = new ArrayList<>();
        myArrayList2.add(10);
        myArrayList2.add(20);
        myArrayList2.add(100);
        System.out.println("add : -> " + myArrayList2);
        myArrayList2.addAll(myArrayList1);
        System.out.println("add all : -> "+myArrayList2);
        // remove all -> it remove common elements
        System.out.println("list 1: -> "+myArrayList1);
        System.out.println("list 2 : -> "+myArrayList2);
       // myArrayList2.removeAll(myArrayList1);
        //System.out.println("remove all : -> "+myArrayList2);
        // retain all -> it retains common elements
        myArrayList2.retainAll(myArrayList1);
        System.out.println("retain all : -> "+myArrayList2);
        // contains
        myArrayList2.contains(100);
        System.out.println("contains : -> "+myArrayList2);

        // toArray
        Object a[] = myArrayList2.toArray();
        System.out.print("To array : -> ");
        for (Object e:a){
            int temp = (int) e;
            System.out.print(temp+" ");
        }
        System.out.println();
        // iterator
         System.out.println();
        Iterator<Integer> iterator = myArrayList1.iterator();
        System.out.print("iterator : -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
         */

        // ***************** Collection Framework Methods *******************************

        // ***************** List Interface Methods *******************************
        myArrayList1.add(100);
        myArrayList1.add(200);
        myArrayList1.add(300);
        myArrayList1.add(400);
        myArrayList1.add(500);
        myArrayList1.add(100);


        System.out.println("add : -> " + myArrayList1);

        // get
        System.out.println("get : -> " + myArrayList1.get(0));
        //set
        myArrayList1.set(1, 999);
        System.out.println("set : -> " + myArrayList1);
        //index of : Returns first occurrence of
        System.out.println("indexOf : -> " + myArrayList1.indexOf(100));
        DemoObject d1 = new DemoObject("Akash", 33, 'M');
        System.out.println("add : -> " + myArrayListObj);
        System.out.println("Demo indexOf : -> " + myArrayListObj.indexOf(d1));
        //last index of : Returns last occurrence of
        System.out.println("lastIndexOf : -> " + myArrayList1.lastIndexOf(100));

        //Iteration
        //for each
        System.out.print("for Each : ->");
        for (int i : myArrayList1) {
            System.out.print(i + " ");
        }
        System.out.println();

        // listIterator
        ListIterator<Integer> listIterator = myArrayList1.listIterator();
        System.out.print("listIterator : -> ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        System.out.println();

        // listIterator(index) -> starts from a specific index
        ListIterator<Integer> listIteratorIndex = myArrayList1.listIterator(1);
        System.out.print("listIteratorIndex : -> ");
        while (listIteratorIndex.hasNext()) {
            System.out.print(listIteratorIndex.next() + " ");
        }
    }
}

class LinkedListClass extends ListInterface {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList1 = new LinkedList<Integer>();
        // We can use LinkedList or List as reference variable since they implement List interface
        //List<Integer> myLinkedList0 = new LinkedList<Integer>();
        LinkedList<DemoObject> myLinkedListObj = new DemoObject().returnLinkedList();
        myLinkedList1.add(100);
        myLinkedList1.add(200);
        myLinkedList1.add(300);
        myLinkedList1.add(400);
        myLinkedList1.add(500);
        myLinkedList1.add(100);

        // ***************** List Interface Methods *******************************

        System.out.println("add : -> " + myLinkedList1);

        // get
        System.out.println("get : -> " + myLinkedList1.get(0));
        //set
        myLinkedList1.set(1, 999);
        System.out.println("set : -> " + myLinkedList1);
        //index of : Returns first occurrence of
        System.out.println("indexOf : -> " + myLinkedList1.indexOf(100));
        DemoObject d1 = new DemoObject("Akash", 33, 'M');
        System.out.println("add : -> " + myLinkedListObj);
        System.out.println("Demo indexOf : -> " + myLinkedListObj.indexOf(d1));
        //last index of : Returns last occurrence of
        System.out.println("lastIndexOf : -> " + myLinkedList1.lastIndexOf(100));

        //Iteration
        //for each
        System.out.print("for Each : ->");
        for (int i : myLinkedList1) {
            System.out.print(i + " ");
        }
        System.out.println();

        // listIterator
        ListIterator<Integer> listIterator = myLinkedList1.listIterator();
        System.out.print("listIterator : -> ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        System.out.println();

        // listIterator(index) -> starts from a specific index
        ListIterator<Integer> listIteratorIndex = myLinkedList1.listIterator(1);
        System.out.print("listIteratorIndex : -> ");
        while (listIteratorIndex.hasNext()) {
            System.out.print(listIteratorIndex.next() + " ");
        }
    }
}

class StackClass extends ListInterface {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        // We can use Stack or List as reference variable since they implement List interface
        //List<Integer> myLinkedList0 = new Stack<Integer>();
        Stack<DemoObject> myStackObj = new DemoObject().returnStack();
        myStack.add(100);
        myStack.add(200);
        myStack.add(300);
        myStack.add(400);
        myStack.add(500);
        myStack.add(100);

        // ***************** List Interface Methods *******************************

        System.out.println("add : -> " + myStack);

        // get
        System.out.println("get : -> " + myStack.get(0));
        //set
        myStack.set(1, 999);
        System.out.println("set : -> " + myStack);
        //index of : Returns first occurrence of
        System.out.println("indexOf : -> " + myStack.indexOf(100));
        DemoObject d1 = new DemoObject("Akash", 33, 'M');
        System.out.println("add : -> " + myStackObj);
        System.out.println("Demo indexOf : -> " + myStackObj.indexOf(d1));
        //last index of : Returns last occurrence of
        System.out.println("lastIndexOf : -> " + myStack.lastIndexOf(100));

        //Iteration
        //for each
        System.out.print("for Each : ->");
        for (int i : myStack) {
            System.out.print(i + " ");
        }
        System.out.println();

        // listIterator
        ListIterator<Integer> listIterator = myStack.listIterator();
        System.out.print("listIterator : -> ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        System.out.println();

        // listIterator(index) -> starts from a specific index
        ListIterator<Integer> listIteratorIndex = myStack.listIterator(1);
        System.out.print("listIteratorIndex : -> ");
        while (listIteratorIndex.hasNext()) {
            System.out.print(listIteratorIndex.next() + " ");
        }
        System.out.println();
        // ***************** Stack Class Methods *******************************
        Stack<Integer> myStack1 = new Stack<>();
        // push -> will push elements on top of one another
        myStack1.push(100);
        myStack1.push(200);
        myStack1.push(300);
        myStack1.push(400);
        myStack1.push(500);
        myStack1.push(999);
        System.out.println("myStack1 : -> "+myStack1);
        // pop -> will remove the last added element
        myStack1.pop();
        System.out.println("myStack1 after pop: -> "+myStack1);
        // peek -> returns the last added element
        System.out.println("myStack1 peek: -> "+myStack1.peek());

    }
}



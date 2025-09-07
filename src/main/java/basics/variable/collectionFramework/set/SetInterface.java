package basics.variable.collectionFramework.set;


import basics.variable.collectionFramework.DemoObject;

import java.util.*;

class StudentPojo {
    String name;
    int rollNo;

    public StudentPojo(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    /*
    Object will be considered same only if there roll number
    is same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPojo that = (StudentPojo) o;
        return rollNo == that.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return "StudentPojo{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }
}

public class SetInterface {
}

class HashSetClass extends SetInterface {
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        Set<StudentPojo> mySetObj = new HashSet<>();


        // ***************** Collection Framework Methods *******************************
        // add
        mySet.add(100);
        mySet.add(200);
        mySet.add(300);
        mySet.add(400);
        mySet.add(500);
        // No order is maintained for hash set
        System.out.println("add : ->" + mySet);
        /*
        Even though we have sonu and saga only one will be added
        based on same roll number
        Even though we have two akash both will be added
        based on unique roll number
         */

        StudentPojo s1 = new StudentPojo("Akash", 10);
        StudentPojo s2 = new StudentPojo("Akash", 20);
        StudentPojo s3 = new StudentPojo("Saga", 30);
        StudentPojo s4 = new StudentPojo("Sonu", 30);

        /*
        Even though names are diff but roll no is same
        so object will be equal based on the custom logic
        we applied for equals method
         */
        System.out.println(s3.equals(s4));
        /*
        hashcode will also be same
         */
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());


        mySetObj.add(s1);
        mySetObj.add(s2);
        mySetObj.add(s3);
        mySetObj.add(s4);


        System.out.println("add : -> " + mySet);
        System.out.println("add : -> " + mySetObj);
        // remove index
        mySet.remove(1);
        mySetObj.remove(1);
        System.out.println("remove index : -> " + mySet);
        System.out.println("Demo remove index : -> " + mySetObj);
        // remove object
        mySet.remove(Integer.valueOf(400));
        DemoObject d1 = new DemoObject("Akash", 33, 'M');
        mySetObj.remove(d1);
        System.out.println("remove object : -> " + mySet);
        System.out.println("Demo remove object : -> " + mySetObj.toString());
        // Add all
        Set<Integer> mySet2 = new HashSet<>();
        mySet2.add(10);
        mySet2.add(20);
        mySet2.add(100);
        System.out.println("add : -> " + mySet2);
        mySet2.addAll(mySet);
        System.out.println("add all : -> " + mySet2);
        // remove all -> it remove common elements
        System.out.println("list 1: -> " + mySet);
        System.out.println("list 2 : -> " + mySet2);
        // mySet2.removeAll(mySet);
        //System.out.println("remove all : -> "+mySet2);
        // retain all -> it retains common elements
        mySet2.retainAll(mySet);
        System.out.println("retain all : -> " + mySet2);
        // contains
        mySet2.contains(100);
        System.out.println("contains : -> " + mySet2.contains(100));

        // toArray
        Object a[] = mySet2.toArray();
        System.out.print("To array : -> ");
        for (Object e : a) {
            int temp = (int) e;
            System.out.print(temp + " ");
        }
        System.out.println();
        // iterator
        System.out.println();
        Iterator<Integer> iterator = mySet.iterator();
        System.out.print("iterator : -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        // ***************** Collection Framework Methods *******************************

    }
}

class LinkedHashSetClass extends SetInterface {
    public static void main(String[] args) {
        Set<Integer> myLinkedHashSet = new java.util.LinkedHashSet<>();
        // add
        myLinkedHashSet.add(500);
        myLinkedHashSet.add(100);
        myLinkedHashSet.add(300);
        myLinkedHashSet.add(400);
        myLinkedHashSet.add(100);
        /*
        It maintains the insertion order
         */
        System.out.println("adds : -> " + myLinkedHashSet);
    }
}

class TreeSetClass extends SetInterface {
    public static void main(String[] args) {
        Set<Integer> myTreeSet = new TreeSet<>();
        // add
        myTreeSet.add(500);
        myTreeSet.add(100);
        myTreeSet.add(300);
        myTreeSet.add(400);
        myTreeSet.add(100);
        /*
        It maintains the ascending order by default
         */
        System.out.println("adds : -> " + myTreeSet);
        System.out.print("My Tree set : -> ");
        for (int s : myTreeSet) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}



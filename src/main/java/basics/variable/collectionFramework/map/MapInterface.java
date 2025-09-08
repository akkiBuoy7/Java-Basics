package basics.variable.collectionFramework.map;

import java.util.*;

public class MapInterface {
}

class HashMapClass extends MapInterface {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new HashMap<>();
        Map<Integer, String> myMapObj = new HashMap<>();
        //put
        myMap.put(90, "lemon");
        myMap.put(1, "apple");
        myMap.put(10, "banana");
        myMap.put(5, "orange");
        myMap.put(9, "lemon");
        /*
        No order is maintained in hash map
         */
        System.out.println("put : -> " + myMap);

        //get
        System.out.println("get : ->" + myMap.get(10));

        //entrySet
        Set<Map.Entry<Integer, String>> entrySet = myMap.entrySet();
        for (Map.Entry<Integer, String> e : entrySet) {
            System.out.print(e + " ");
        }
        System.out.println();
        // keys
        Set<Integer> keys = myMap.keySet();
        for (Integer e : keys) {
            System.out.print(e + " ");
        }
        System.out.println();
        // values
        Collection<String> values = myMap.values();
        for (String e : values) {
            System.out.print(e + " ");
        }
        System.out.println();
        // default
        myMap.getOrDefault(1, "No fruit");
    }
}

class LinkedHashMapClass extends MapInterface {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new LinkedHashMap<>();
        //put
        myMap.put(90, "lemon");
        myMap.put(1, "apple");
        myMap.put(10, "banana");
        myMap.put(5, "orange");
        myMap.put(9, "lemon");
        /*
        Insertion order is maintained in linked hash map
         */
        System.out.println("put : -> " + myMap);
    }
}

class TreeMapClass extends MapInterface {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new TreeMap<>();

        //put
        myMap.put(90, "lemon");
        myMap.put(1, "apple");
        myMap.put(10, "banana");
        myMap.put(5, "orange");
        myMap.put(9, "lemon");

        /*
        Ascending order of keys is maintained
         */
        System.out.println("put : -> " + myMap);
    }
}



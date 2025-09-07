package basics.variable.collectionFramework.queue;

import basics.variable.collectionFramework.DemoObject;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueInterface {
}

class LinkedListClassQ extends QueueInterface {
    public static void main(String[] args) {
        // ***************** Collection Framework Methods *******************************

        Queue<Integer> myLinkedListQ = new LinkedList<>();
        Queue<DemoObject> myLinkedListQObj = new DemoObject().returnLinkedList();
 /*
        // add
        myLinkedListQ.add(100);
        myLinkedListQ.add(200);
        myLinkedListQ.add(300);
        myLinkedListQ.add(400);
        myLinkedListQ.add(500);


        System.out.println("add : -> " + myLinkedListQ);
        System.out.println("add : -> " + myLinkedListQObj);
        // remove index
        myLinkedListQ.remove(1);
        myLinkedListQObj.remove(1);
        System.out.println("remove index : -> " + myLinkedListQ);
        System.out.println("Demo remove index : -> " + myLinkedListQObj);
        // remove object
        myLinkedListQ.remove(Integer.valueOf(400));
        DemoObject d1 = new DemoObject("Akash", 33, 'M');
        myLinkedListQObj.remove(d1);
        System.out.println("remove object : -> " + myLinkedListQ);
        System.out.println("Demo remove object : -> " + myLinkedListQObj.toString());
        // Add all
        Queue<Integer> myLinkedList2 = new LinkedList<>();
        myLinkedList2.add(10);
        myLinkedList2.add(20);
        myLinkedList2.add(100);
        System.out.println("add : -> " + myLinkedList2);
        myLinkedList2.addAll(myLinkedListQ);
        System.out.println("add all : -> " + myLinkedList2);
        // remove all -> it remove common elements
        System.out.println("list 1: -> " + myLinkedListQ);
        System.out.println("list 2 : -> " + myLinkedList2);
        // myLinkedList2.removeAll(myArrayList1);
        //System.out.println("remove all : -> "+myLinkedList2);
        // retain all -> it retains common elements
        myLinkedList2.retainAll(myLinkedListQ);
        System.out.println("retain all : -> " + myLinkedList2);
        // contains
        System.out.println("contains : -> " + myLinkedList2.contains(100));

        // toArray
        Object a[] = myLinkedList2.toArray();
        System.out.print("To array : -> ");
        for (Object e : a) {
            int temp = (int) e;
            System.out.print(temp + " ");
        }
        System.out.println();
        // iterator
        System.out.println();
        Iterator<Integer> iterator = myLinkedListQ.iterator();
        System.out.print("iterator : -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
        */
        // ***************** Collection Framework Methods *******************************

        // ***************** Queue Interface Methods *******************************

        // offer(add) : -> will add from the end
        /*
        Add may throw exception but offer will return boolean on success(true) or failure(false)
         */
        myLinkedListQ.add(10);
        myLinkedListQ.add(20);
        myLinkedListQ.add(30);
        myLinkedListQ.add(40);

        System.out.println(myLinkedListQ);

        // poll (remove): -> will remove from the beginning
        /*
        Remove may throw exception if collection is null but poll will return null
         */
        System.out.println(myLinkedListQ.poll());
        System.out.println(myLinkedListQ);
        // peek : -> will show next element in the line which can be polled
        System.out.println(myLinkedListQ.peek());
        System.out.println(myLinkedListQ);

        // Iteration using poll
        while (!myLinkedListQObj.isEmpty()) {
            System.out.println(myLinkedListQObj.poll());
        }

        // polling an empty array will give null
        System.out.println(myLinkedListQObj.poll());

    }
}

class ArrayDequeueClass extends QueueInterface {
    public static void main(String[] args) {

        // ***************** Queue Interface Methods *******************************

        /*
        Queue<Integer> myDeque = new ArrayDeque<>();
        Queue<DemoObject> myDequeObj = new DemoObject().returnDequeueList();

        // offer(add) : -> will add from the end

        // Add may throw exception but offer will return boolean on success(true) or failure(false)

        myDeque.add(10);
        myDeque.add(20);
        myDeque.add(30);
        myDeque.add(40);

        System.out.println(myDeque);

        // poll (remove): -> will remove from the beginning

        // Remove may throw exception if collection is null but poll will return null

        System.out.println(myDeque.poll());
        System.out.println(myDeque);
        // peek : -> will show next element in the line which can be polled
        System.out.println(myDeque.peek());
        System.out.println(myDeque);

        // Iteration using poll
        while (!myDequeObj.isEmpty()) {
            System.out.println(myDequeObj.poll());
        }

        // polling an empty array will give null
        System.out.println(myDequeObj.poll());

        */
        // ***************** Queue Interface Methods *******************************

        // ***************** Dequeue Interface Methods *******************************

        /*
        ArrayDeque<Integer> myArrayDeque = new ArrayDeque();
        // offer
        myArrayDeque.offer(10); // will add at the front
        myArrayDeque.offerFirst(100); // will also add at the front of 10
        myArrayDeque.offerLast(300); // will add at the back

        System.out.println("offer types : -> " + myArrayDeque);

        // poll
        System.out.println("poll : -> " + myArrayDeque.poll()); // will remove from front
        System.out.println("poll last : -> " + myArrayDeque.pollLast()); // will remove from back

        //peek
        myArrayDeque.offer(10);
        myArrayDeque.offerFirst(100);
        myArrayDeque.offerLast(300);
        System.out.println("peek first : -> " + myArrayDeque.peekFirst());
        System.out.println("peek : -> " + myArrayDeque.peek());
        System.out.println("peek last : -> " + myArrayDeque.peekLast());

        */

        // ***************** Dequeue Interface Methods *******************************

        // ***************** Dequeue(FIFO) vs Stack(LIFO) *******************************
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // stack will add from front using push
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack : ->" + stack);

        // stack will remove from the front using pop
        System.out.println(stack.pop());
        System.out.println(stack);

        //stack will peek from the front
        System.out.println(stack.peek());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // queue will add from back using offer
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Stack : ->" + queue);

        // queue will remove from the front using poll
        System.out.println(queue.poll());
        System.out.println(queue);

        //queue will peek from the front
        System.out.println(queue.peek());
    }
}

class PriorityQueueClass extends QueueInterface {

    public static void main(String[] args) {
        PriorityQueue<Integer> myPriorityQueue = new PriorityQueue<>();
        myPriorityQueue.add(100);
        myPriorityQueue.add(4);
        myPriorityQueue.add(30);
        myPriorityQueue.add(9);
        /*
        It will arrange elements based on priority
        Integer priority is ascending order
         */
        System.out.println(myPriorityQueue);

        PriorityQueue<Character> myPriorityQueueS = new PriorityQueue<>();
        myPriorityQueueS.add('s');
        myPriorityQueueS.add('a');
        myPriorityQueueS.add('z');
        myPriorityQueueS.add('m');
        /*
        It will arrange elements based on priority
        String/Character priority is alphabetical order
         */
        System.out.println(myPriorityQueueS);
    }
}



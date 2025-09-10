package multithreading;

public class IntrinsicThreading {
    public static void main(String[] args) throws InterruptedException {

        /*
        Since both thread accessing the same counter object , so 2000 will not be
        printed always. It will lead to bad results as counter value is changed simultaneously by
        the threads
         */
        Counter counter = new Counter();
        CounterThread t1 = new CounterThread(counter, "t1");
        CounterThread t2 = new CounterThread(counter, "t1");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final counter is " + counter.getCount());



        /*
        Since incrementCounterSync is synchronized so one thread can only access
        the method at a given time. So it will always print 2000
         */
        Counter counter1 = new Counter();
        CounterThreadSync t3 = new CounterThreadSync(counter1, "t1");
        CounterThreadSync t4 = new CounterThreadSync(counter1, "t1");
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("Final counter for synchronized is " + counter1.getCount());
    }
}

class Counter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void incrementCounter() {
        count++;
    }

    public synchronized void incrementCounterSync() {
        count++;
    }

    /*
    if want sync only a part of code inside the method
     */
    public void incrementCounterSync1() {
        synchronized (this) {
            count++;
        }

    }
}

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.incrementCounter();
        }
    }
}

class CounterThreadSync extends Thread {
    private Counter counter;

    public CounterThreadSync(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //counter.incrementCounterSync();
            counter.incrementCounterSync1();
        }
    }
}



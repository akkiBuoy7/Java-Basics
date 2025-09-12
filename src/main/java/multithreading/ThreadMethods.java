package multithreading;

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        ThreadM threadM = new ThreadM();
        System.out.println("start :-> Thread started");
        threadM.start();// start method to start thread
        Thread.sleep(5000); // sleeping the main thread
        threadM.interrupt(); // interrupt the thread
    }
}


class ThreadPriority {
    public static void main(String[] args) throws InterruptedException {
        ThreadP threadl = new ThreadP("Low priority");
        threadl.setPriority(Thread.MIN_PRIORITY);
        ThreadP threadm = new ThreadP("Medium priority");
        threadm.setPriority(Thread.NORM_PRIORITY);
        ThreadP threadh = new ThreadP("High priority");
        threadh.setPriority(Thread.MAX_PRIORITY);

        threadl.start();
        threadm.start();
        threadh.start();

        ThreadM threadM = new ThreadM();
        System.out.println("start :-> Thread started");
        threadM.start();// start method to start thread
        threadM.join();
        System.out.println("Thread ended");


        ThreadYield t1 = new ThreadYield("t1");
        ThreadYield t2 = new ThreadYield("t2");
        t1.start();
        t2.start();
        Thread.yield(); // unlocking cpu for both the threads to run concurrently
    }

}

class ThreadM extends Thread {
    @Override
    public void run() { // run method to run the thread logic
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("run :-> Thread is running " + i);
            } catch (InterruptedException e) {
                System.out.println("interrupt :-> Thread interrupted");
                break; // Exit the loop
            }
        }
    }
}

class ThreadP extends Thread {
    public ThreadP(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }
}

class ThreadYield extends Thread {
    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "is running");
        }
    }
}

class Test {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread("Daemon Thread");
        daemonThread.start();
        System.out.println("Main thread done !");
    }
}

class DaemonThread extends Thread {
    public DaemonThread(String name) {
        super(name);
        /*
        JVM will exit even if infinite while loop is there.
        JVM never waits for Daemon thread
         */
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "is running");
        }
    }
}

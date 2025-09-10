package multithreading;

public class ThreadingBasic {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        /*
           Main thread to run long running task
         */
        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class MyThread extends Thread {
    /*
       Thread class to create thread
        */
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class MyRunnable implements Runnable {
    /*
       Runnable interface to create thread
     */
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private int count = 0;

    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    /*
    ReadLock allows multiple threads to read the same resource simultaneously.
    Multiple threads can access the lock and do read operations , if any write
    operation is not currently going on , or if the WriteLock is not holding the lock.
     */
    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }
}

class ReadWriteClass {
    public static void main(String[] args) {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(
                            Thread.currentThread().getName() + " Read : " + counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                    System.out.println(
                            Thread.currentThread().getName() + " Write : " + counter.getCount() +
                                    " INCREMENTED");
                }
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);

        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        try {
            writerThread.join();
            readerThread1.join();
            readerThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(Thread.currentThread().getName()+" Final Read (main thread): " + counter.getCount());

    }
}

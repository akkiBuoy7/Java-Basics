package multithreading;

public class ThreadLifecycle {
    public static void main(String[] args) throws InterruptedException {

        MyThreadL myThreadL = new MyThreadL();
        System.out.println(myThreadL.getState()); // new
        myThreadL.start();
        System.out.println(myThreadL.getState()); // runnable
        myThreadL.join();
        System.out.println(myThreadL.getState()); // terminated
    }
}

class MyThreadL extends Thread{
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

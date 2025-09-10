package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ExplicitThreading {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                //bankAccount.withdraw(50);
                //bankAccount.withdrawLock(50);
                // bankAccount.withdrawTryLock(50);;
                //bankAccount.withdrawTryLockTimeout(50);
                //bankAccount.withdrawLockIterruptibly(50);
            }
        };

        Thread withdrawer1 = new Thread(task, "withdrawer 1");
        Thread withdrawer2 = new Thread(task, "withdrawer 2");

        withdrawer1.start();
        try {
            Thread.sleep(10); // delay withdrawer2 to let withdrawer1 go first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        withdrawer2.start();


        // Interrupt t2 after 2 seconds to simulate cancellation
        // use this only for withdrawLockIterruptibly
        try {
            Thread.sleep(2000);
            withdrawer1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }


    }
}


class BankAccount {
    // fair=true means every thread will fairly get chance to lock and unlock
    Lock lock = new ReentrantLock(true);
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        /*
            RESPONSE OF synchronized void withdraw (Intrinsic)
            withdrawer 1: Attempting to withdraw 50
            withdrawer 1: Proceeding with withdrawal 50
            withdrawer 1: Completed withdrawal having remaining balance 50

            =========================================================
            HERE WITHDRAWER 2 WILL BE IN LINE WAITING TO GET THE
            LOCK OF THE THREAD. WHEN WITHDRAWER 1 HAS FINISHED
            THEN ONLY UNLOCK FOR 1 WILL HAPPEN AND 2 WILL WITHDRAW
            =========================================================

            withdrawer 2: Attempting to withdraw 50
            withdrawer 2: Proceeding with withdrawal 50
            withdrawer 2: Completed withdrawal having remaining balance 0
 */
        System.out.println(Thread.currentThread().getName() + ": Attempting to withdraw " + amount);
        if (balance >= amount) {
            System.out.println(
                    Thread.currentThread().getName() + ": Proceeding with withdrawal " + amount);
            try {
                Thread.sleep(5000);
                balance -= amount;
                System.out.println(
                        Thread.currentThread().getName() + ": Completed withdrawal having " +
                                "remaining balance" +
                                " " + balance);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " Sleep Interruption" +
                        " occurred ");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": Insufficient balance ");
        }
    }

    public void withdrawLock(int amount) {
        /*
            withdrawer 1: Attempting to withdraw 50
            withdrawer 1: Proceeding with withdrawal 50
            withdrawer 2: Attempting to withdraw 50
            withdrawer 1 Sleep Interruption occurred
            =====================================================
            After 2 sec withdrawer 1 is interrupted and hence unlocked, so
            withdrawer 2 could proceed with the locking
            =====================================================
            withdrawer 2: Proceeding with withdrawal 50
            withdrawer 2: Completed withdrawal having remaining balance 50


 */
        System.out.println(Thread.currentThread().getName() + ": Attempting to withdraw " + amount);
        try {
            lock.lockInterruptibly();
            if (balance >= amount) {
                System.out.println(
                        Thread.currentThread()
                                .getName() + ": Proceeding with withdrawal " + amount);
                try {
                    Thread.sleep(5000);
                    balance -= amount;
                    System.out.println(
                            Thread.currentThread()
                                    .getName() + ": Completed withdrawal having " +
                                    "remaining balance" +
                                    " " + balance);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " Sleep Interruption" +
                            " occurred ");
                } finally {
                    lock.unlock(); // EVERY LOCK SHOULD BE UNLOCKED
                }

            } else {
                System.out
                        .println(Thread.currentThread().getName() + ": Insufficient balance ");
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " Interruption occurred ");
        }


    }

    public void withdrawTryLock(int amount) {
        /*
            withdrawer 1: Attempting to withdraw 50
            withdrawer 1: Proceeding with withdrawal 50
            withdrawer 2: Attempting to withdraw 50
            =================================================================
            withdrawer 2 using tryLock() tried to see if it is locked. Since it is
            locked IT WILL INSTANTLY RETURN FALSE AND WILL NOT WAIT like synchronised case.
            It will stop trying and exit.
            =================================================================
            withdrawer 2: Withdrawing is not possible
            withdrawer 1: Completed withdrawal having remaining balance 50

 */
        System.out.println(Thread.currentThread().getName() + ": Attempting to withdraw " + amount);
        try {
            if (lock.tryLock()) {
                if (balance >= amount) {
                    System.out.println(
                            Thread.currentThread()
                                    .getName() + ": Proceeding with withdrawal " + amount);
                    try {
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(
                                Thread.currentThread()
                                        .getName() + ": Completed withdrawal having " +
                                        "remaining balance" +
                                        " " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out
                                .println(Thread.currentThread().getName() + " Sleep Interruption" +
                                        " occurred ");
                    } finally {
                        lock.unlock(); // EVERY LOCK SHOULD BE UNLOCKED
                    }

                } else {
                    System.out
                            .println(Thread.currentThread().getName() + ": Insufficient balance ");
                }
            } else {
                System.out.println(
                        Thread.currentThread().getName() + ": Withdrawing is not possible ");
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " Interruption occurred ");
        }


    }

    public void withdrawTryLockTimeout(int amount) {
        /*
            withdrawer 1: Attempting to withdraw 50
            withdrawer 2: Attempting to withdraw 50
            withdrawer 1: Proceeding with withdrawal 50
            withdrawer 1: Completed withdrawal having remaining balance 50
            ==================================================================
            withdrawer 2 waited 7 secs for the withdrawer 1 to finish and unlock after 5 secs
            After withdrawer 1 has unlocked , withdrawer 2 started locking, thus
            a> WITHOUT EXITING IMMEDIATELY LIKE THE CASE OF tryLock()
            or
            b> WAITING INFINITELY LIKE THE CASE OF SYNCHRONISED
            ==================================================================
            withdrawer 2: Proceeding with withdrawal 50
            withdrawer 2: Completed withdrawal having remaining balance 0


 */
        System.out.println(Thread.currentThread().getName() + ": Attempting to withdraw " + amount);
        try {
            if (lock.tryLock(7000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    System.out.println(
                            Thread.currentThread()
                                    .getName() + ": Proceeding with withdrawal " + amount);
                    try {
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(
                                Thread.currentThread()
                                        .getName() + ": Completed withdrawal having " +
                                        "remaining balance" +
                                        " " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out
                                .println(Thread.currentThread().getName() + " Sleep Interruption" +
                                        " occurred ");
                    } finally {
                        lock.unlock(); // EVERY LOCK SHOULD BE UNLOCKED
                    }

                } else {
                    System.out
                            .println(Thread.currentThread().getName() + ": Insufficient balance ");
                }
            } else {
                System.out.println(
                        Thread.currentThread().getName() + ": Withdrawing is not possible ");
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " Interruption occurred ");
        }


    }

    public void withdrawLockIterruptibly(int amount) {
        /*
            withdrawer 1: Attempting to withdraw 50
            withdrawer 1: Proceeding with withdrawal 50
            withdrawer 2: Attempting to withdraw 50
            withdrawer 1 Sleep Interruption occurred
            =====================================================
            After 2 sec withdrawer 1 is interrupted and hence unlocked, so
            withdrawer 2 could proceed with the locking
            =====================================================
            withdrawer 2: Proceeding with withdrawal 50
            withdrawer 2: Completed withdrawal having remaining balance 50


 */
        System.out.println(Thread.currentThread().getName() + ": Attempting to withdraw " + amount);
        try {
            lock.lockInterruptibly();
            if (balance >= amount) {
                System.out.println(
                        Thread.currentThread()
                                .getName() + ": Proceeding with withdrawal " + amount);
                try {
                    Thread.sleep(5000);
                    balance -= amount;
                    System.out.println(
                            Thread.currentThread()
                                    .getName() + ": Completed withdrawal having " +
                                    "remaining balance" +
                                    " " + balance);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " Sleep Interruption" +
                            " occurred ");
                } finally {
                    lock.unlock(); // EVERY LOCK SHOULD BE UNLOCKED
                }

            } else {
                System.out
                        .println(Thread.currentThread().getName() + ": Insufficient balance ");
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " Interruption occurred ");
        }


    }
}





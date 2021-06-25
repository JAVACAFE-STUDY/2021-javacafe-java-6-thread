package org.javacafe.thread;

import java.util.concurrent.TimeUnit;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            System.out.println("sleep for 5 second..");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hi thread!");
        };

        Thread thread1 = new Thread(task1);
        thread1.start();
        System.out.println("start");
        thread1.join(10000);
        //thread1.join(1000);
        System.out.println("joined");
    }
}

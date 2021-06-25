package org.javacafe.thread;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("sleep for 5 second..");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hi thread!");
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}

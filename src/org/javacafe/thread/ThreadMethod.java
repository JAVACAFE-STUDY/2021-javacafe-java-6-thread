package org.javacafe.thread;

import java.util.concurrent.TimeUnit;

public class ThreadMethod {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println("hi thread!");
        };

        Thread thread = new Thread(task,"hello");
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(Thread.activeCount());
        System.out.println(thread.getState());
        thread.join(10000);
        System.out.println(thread.getState());
    }
}

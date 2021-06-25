package org.javacafe.thread;

public class HelloThread {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("hi thread!");
        };

        Thread thread = new Thread(task);
        thread.start();


        ThreadTask r = new ThreadTask();
        Thread thread2 = new Thread(r);
        thread2.start();
    }
}

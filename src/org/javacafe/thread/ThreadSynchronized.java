package org.javacafe.thread;

public class ThreadSynchronized {

    static class Sum{
        int num = 0;

        int sum(){
            for(int i=0; i<10000; i++){
                num += 1;
            }
            return num;
        }
    }

    static class Sum2{
        int num = 0;

        synchronized int sum(){
            for(int i=0; i<10000; i++){
                num += 1;
            }
            return num;
        }
    }


    public static void main(String[] args) {
        //objectSynchronized();
        methodSynchronized();
    }

    public static void objectSynchronized(){
        Sum s = new Sum();

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            synchronized(s){
                System.out.println(threadName+":"+s.sum());
            }
            System.out.println("hi objectSynchronized");
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }

    public static void methodSynchronized(){
        Sum2 s = new Sum2();

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+":"+s.sum());
            System.out.println("hi thread!");
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }

}

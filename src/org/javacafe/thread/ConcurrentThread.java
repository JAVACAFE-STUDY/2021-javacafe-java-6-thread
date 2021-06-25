package org.javacafe.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentThread {
  public static void main(String[] args){
    Runnable sayHello = () -> {
      for(int i = 1; i <= 100; i++){
        System.out.println("Hello " + i);
      }
    };

    Runnable sayGoodbye = () -> {
      for(int i = 1; i <= 100; i++){
        System.out.println("Goodbye " + i);
      }
    };

    // Executor
//    Executor exec = Executors.newCachedThreadPool();
//    exec.execute(sayHello);
//    exec.execute(sayGoodbye);

    // ExecutorService
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.submit(sayHello);
    exec.submit(sayGoodbye);
    exec.shutdown();
  }


}

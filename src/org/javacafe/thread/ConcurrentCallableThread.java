package org.javacafe.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrentCallableThread {
  public static void main(String[] args) {
    Callable<String> task = () -> {
      System.out.println("hello thread!");
      TimeUnit.SECONDS.sleep(10000);
      return "goodbye thread!";
    };

    ExecutorService exec = Executors.newCachedThreadPool();


    Future<String> future = exec.submit(task);
    try{
      //System.out.println("is Cancelled :" + future.isCancelled());
      //future.cancel(true);
      //String result = future.get();
      System.out.println("is Done :" + future.isDone());
      String result = future.get(5, TimeUnit.SECONDS);

      System.out.println(result);

    } catch (Exception e){
      e.printStackTrace();
    } finally {
      System.out.println("is Cancelled :" + future.isCancelled());
      System.out.println("is Done :" + future.isDone());
      exec.shutdown();
    }
  }
}

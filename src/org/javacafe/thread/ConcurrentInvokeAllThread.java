package org.javacafe.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentInvokeAllThread {
  public static void main(String[] args) {
    List<Callable<String>> tasks = new ArrayList<>();
    for(int i = 0; i < 10; i++) {
      tasks.add(
          () -> {
            String threadName = Thread.currentThread().getName();
            return threadName;
          }
      );
    }
    ExecutorService exec = Executors.newCachedThreadPool();
    try{
      List<Future<String>> results = exec.invokeAll(tasks);
      for(Future<String> result : results){
        System.out.println(result.get());
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } finally {
      exec.shutdown();
    }
  };

}

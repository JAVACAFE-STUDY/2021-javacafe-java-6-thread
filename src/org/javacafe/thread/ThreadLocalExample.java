package org.javacafe.thread;

import java.text.NumberFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalExample {

  public static final NumberFormat currentFormat = NumberFormat.getCurrencyInstance();
  //public static final ThreadLocal<NumberFormat> currentFormat = ThreadLocal.withInitial(()-> NumberFormat.getNumberInstance());

  public static String amountDue ;
  public static void main(String[] args){
    //String amountDue = currentFormat.format(100000);
    //System.out.println(amountDue);

    Runnable task = () -> {
      //String threadName = Thread.currentThread().getName();
      //System.out.println("threadName ==> " + threadName);
      String amountDue = currentFormat.format(12345689);
//      try {
//        TimeUnit.SECONDS.sleep(1);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
      System.out.println("hi :" + amountDue);
    };

    ExecutorService exec = Executors.newFixedThreadPool(5);
    for(int i = 0; i < 500; i++){
      exec.submit(task);
    }
    exec.shutdown();
  }
}

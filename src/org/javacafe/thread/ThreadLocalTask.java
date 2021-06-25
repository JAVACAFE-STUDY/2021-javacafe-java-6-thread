package org.javacafe.thread;

import java.text.NumberFormat;

public class ThreadLocalTask implements Runnable{
  public static final NumberFormat currentFormat = NumberFormat.getCurrencyInstance();
  @Override
  public void run() {
    String amountDue = currentFormat.format(10000);
    System.out.println("hi :" + amountDue);
  }
}

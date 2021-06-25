package org.javacafe.thread;

public class ThreadTask implements Runnable{
  private int no = 0;
  public void setNo(int n){
    this.no = n;
  }
  @Override
  public void run() {
    System.out.println("hi ThreadTask :" + this.no);
  }
}

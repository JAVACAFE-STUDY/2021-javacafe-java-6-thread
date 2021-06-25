package org.javacafe.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;

public class SimpleDateFormatTest {
  static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
  private SimpleDateFormat getFormat() {
    return new SimpleDateFormat("yyyyMMdd");
  }
  //static final ThreadLocal<SimpleDateFormat> format = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

  @Test
  public void SimpleDateFormatIsNotSafeTest() {

    // init
    ExecutorService exec = Executors.newFixedThreadPool(5);
    List<Future<String>> results = new ArrayList<Future<String>>();

    try {
      Callable<String> task = new Callable<String>() {
        //SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        public String call() throws Exception {
          String threadName = Thread.currentThread().getName();
          System.out.println("threadName ==> " + threadName);
          //SimpleDateFormat sdf = getFormat();
          return format.parse("20210626").toString();
					//return getFormat().parse("20150630"); // 정상 동작시키기 위해서는 이와 같이 사용해야 함
        }
      };

      // 10건 수행
      for (int i = 0; i < 1; i++) {
        results.add(exec.submit(task));
      }

      // 결과 출력
      for (Future<String> result : results) {
        System.out.println(result.get());
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      exec.shutdown();
    }

  }
}

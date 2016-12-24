package will.study.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by will on 16/9/3.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " loop of " + j + " for task of " + task);
                    }
                }
            });
            System.out.println("all of 10 tasks have committed");
//            threadPool.shutdown();
        }

        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("Bombing!");
            }
        }, 6, 2, TimeUnit.SECONDS);
    }

}

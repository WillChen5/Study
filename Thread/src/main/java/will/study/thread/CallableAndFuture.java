package will.study.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by will on 16/9/3.
 */
public class CallableAndFuture {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<String> future = threadPool.submit(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Hello";
            }
        });

        System.out.println("等待结果");
        try {
            System.out.println("拿到结果" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);

        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            completionService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return finalI;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }
}

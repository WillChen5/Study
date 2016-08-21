package will.study.thread;

/**
 * Created by will on 16/8/21.
 */
public class MyRunnable implements Runnable{
    private int i =0;

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

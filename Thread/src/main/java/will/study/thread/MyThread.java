package will.study.thread;

/**
 * Created by will on 16/8/21.
 */
public class MyThread extends Thread{
    private int i =0;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

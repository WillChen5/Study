package will.study.thread;

/**
 * Created by will on 16/9/3.
 */
public class MultiThreadShareData {

    public static void main(String[] args) {
        final ShareData data1 = new ShareData();

        new Thread(new MyRunnable1(data1)).start();
        new Thread(new MyRunnable2(data1)).start();
    }
}

class MyRunnable1 implements Runnable{

    private final ShareData data1;

    public MyRunnable1(ShareData data1){
        this.data1 = data1;
    }

    public void run() {
        data1.decrement();
    }
}

class MyRunnable2 implements Runnable{

    private final ShareData data1;

    public MyRunnable2(ShareData data1){
        this.data1 = data1;
    }

    public void run() {
        data1.increment();
    }
}

class ShareData{
    private int j = 0;
    public synchronized void increment(){
        j++;
    }

    public synchronized void decrement(){
        j--;
    }

   /* private int count = 100;
    public void run() {
        while (true){
            count --;
        }
    }*/
}
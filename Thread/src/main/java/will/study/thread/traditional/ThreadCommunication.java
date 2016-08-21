package will.study.thread.traditional;

/**
 * Created by will on 16/8/21.
 */
public class ThreadCommunication {

    public static void main(String[] args) {

        final Business business = new Business();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            business.main(i);
        }
    }
}

class Business{
    boolean bShouldSub = false;

    public synchronized void sub(int i){
        if(!bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < 10; j++) {
            System.out.println("sub thread sequece of " + j + ", loop of " + i);
        }

        bShouldSub = false;
        this.notify();
    }

    public synchronized void main(int i){
        if(bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < 100; j++) {
            System.out.println("main thread sequece of " + j + ", loop of " + i);
        }

        bShouldSub = true;
        this.notify();
    }
}
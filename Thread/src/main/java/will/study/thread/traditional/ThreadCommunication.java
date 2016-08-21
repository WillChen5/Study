package will.study.thread.traditional;

/**
 * Created by will on 16/8/21.
 */
public class ThreadCommunication {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {

                    synchronized(ThreadCommunication.class){
                        for (int j = 0; j < 10; j++) {
                            System.out.println("sub thread sequece of " + j + " loop of " + i);
                        }
                    }

                }
            }
        });

        for (int i = 0; i < 50; i++) {
            synchronized(ThreadCommunication.class){
                for (int j = 0; j < 10; j++) {
                    System.out.println("main thread sequece of " + j + " loop of " + i);
                }
            }

        }
    }
}

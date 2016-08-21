package will.study.thread.traditional;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by will on 16/8/21.
 */
public class TimerTest {

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        }, 10000, 3000);

        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

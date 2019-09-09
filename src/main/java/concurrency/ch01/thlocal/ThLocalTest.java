//SRC-03
package concurrency.ch01.thlocal;

import java.util.concurrent.TimeUnit;

public class ThLocalTest {
    public static void main(String[] args) {
        ThLocalTask ts = new ThLocalTask();

        for(int i=0; i<10; i++) {
            Thread th = new Thread(ts);
            th.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package concurrency.ch01.thfactory;

import java.util.concurrent.TimeUnit;

public class FactoryTask implements  Runnable {
    @Override
    public void run() {
        System.out.println("Running Factory Task");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished Factory Task");
    }
}

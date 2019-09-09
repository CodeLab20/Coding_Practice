package concurrency.ch03.semaphores.binary;

import concurrency.ch03.semaphores.common.PrinterI;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SinglePrinter implements PrinterI {
    private final Semaphore sm = new Semaphore(1);

    public void printDocument(Object obj)
    {
        try {
            sm.acquire();
            long duration = (long)(Math.random()*10);
            System.out.println("Thread-" + Thread.currentThread().getId() + " printing job for " + duration + " seconds");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            sm.release();
        }
    }
}

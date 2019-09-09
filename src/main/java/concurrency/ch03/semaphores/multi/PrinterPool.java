package concurrency.ch03.semaphores.multi;

import concurrency.ch03.semaphores.common.PrinterI;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterPool implements PrinterI {
    private static final int printerPoolSize = 3;
    private Semaphore sm = new Semaphore(printerPoolSize);
    private Lock lock = new ReentrantLock();
    private boolean printers[] = new boolean[]{true, true, true};


    @Override
    public void printDocument(Object obj) {
        try {
            sm.acquire();

            int pid = getPrinter();

            long duration = (long)(Math.random() * 10);
            System.out.println("Thread-" + Thread.currentThread().getId() + " printing job on printer :" + pid
                    + " for " + duration + " seconds");
            TimeUnit.SECONDS.sleep(duration);
            printers[pid] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            sm.release();
        }
    }

    private int getPrinter() {
        lock.lock();

        int ret = -1;
        for(int i=0; i< printerPoolSize; i++)
            if(printers[i])
            {
                ret = i;
                printers[i] = false;
                break;
            }

        lock.unlock();
        return ret;
    }
}

//SRC-09
package concurrency.ch03.semaphores;

import concurrency.ch03.semaphores.common.PrinterI;
import concurrency.ch03.semaphores.common.PrinterJob;
import concurrency.ch03.semaphores.multi.PrinterPool;

public class MultiSemaphoreTest {
    public static void main(String[] args) {
        PrinterI p = new PrinterPool();

        for(int i=0 ; i<10; i++)
        {
            PrinterJob jb = new PrinterJob(p);
            Thread th = new Thread(jb);
            th.start();
        }
    }
}

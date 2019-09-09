//SRC-08
package concurrency.ch03.semaphores;

import concurrency.ch03.semaphores.binary.SinglePrinter;
import concurrency.ch03.semaphores.common.PrinterJob;

public class BinarySemaphoreTest {
    public static void main(String[] args) {
        SinglePrinter p = new SinglePrinter();

        for(int i=0 ; i<10; i++)
        {
            PrinterJob jb = new PrinterJob(p);
            Thread th = new Thread(jb);
            th.start();
        }
    }
}

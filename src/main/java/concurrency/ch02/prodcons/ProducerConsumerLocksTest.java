//SRC-06
package concurrency.ch02.prodcons;

import concurrency.ch02.prodcons.commons.Consumer;
import concurrency.ch02.prodcons.commons.Producer;
import concurrency.ch02.prodcons.commons.Storage;
import concurrency.ch02.prodcons.locks.ProductStorageWithLocks;

public class ProducerConsumerLocksTest {
    public static void main(String[] args) {
        Storage storage = new ProductStorageWithLocks(10);

        for(int i=0; i< 4; i++)
        {
            Producer pr = new Producer(String.valueOf(i), storage);
            Thread th = new Thread(pr);
            th.start();
        }


        for(int i=0; i< 2; i++)
        {
            Consumer cr = new Consumer(i, storage);
            Thread th = new Thread(cr);
            th.start();
        }
    }
}

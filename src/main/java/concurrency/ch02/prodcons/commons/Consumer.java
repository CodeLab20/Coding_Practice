package concurrency.ch02.prodcons.commons;

import concurrency.ch02.prodcons.sync.ProductStorage;

public class Consumer implements Runnable {
    private int id;
    private Storage storage;

    public Consumer(int id, Storage storage)
    {
        this.id = id;
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0; i<30; i++) {
            Product p = storage.getProduct();
            System.out.println(p + " Consumed from storage by Consumer id:" + id);
        }
    }
}

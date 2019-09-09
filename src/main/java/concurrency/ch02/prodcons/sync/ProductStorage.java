package concurrency.ch02.prodcons.sync;

import concurrency.ch02.prodcons.commons.Product;
import concurrency.ch02.prodcons.commons.Storage;

import java.util.LinkedList;

public class ProductStorage implements Storage {
    private int max_size = -1;
    private LinkedList<Product> storage = null;

    public ProductStorage(int capacity)
    {
        max_size = capacity;
        storage = new LinkedList<Product>();
    }

    public synchronized void  addProduct(Product p1)
    {
        //If storage is full, wait.
        while(storage.size() == max_size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.offer(p1);

        //This notifyAll is to wake up all the consumer threads who are waiting to consume from storage
        notifyAll();
    }

    public synchronized  Product getProduct()
    {
        //If storage is empty, wait.
        while(storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Product p = storage.pollFirst();

        //This notifyAll is to wake up all producer threads who are waiting to add product to storage
        notifyAll();
        return p;
    }
}

package concurrency.ch02.prodcons.locks;

import concurrency.ch02.prodcons.commons.Product;
import concurrency.ch02.prodcons.commons.Storage;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductStorageWithLocks implements Storage {
    private int max_size = -1;
    private LinkedList<Product> storage = null;
    private Lock lock = new ReentrantLock();
    private Condition storageFull = lock.newCondition();
    private Condition storageEmpty = lock.newCondition();

    public ProductStorageWithLocks(int capacity)
    {
        max_size = capacity;
        storage = new LinkedList<Product>();
    }

    public void  addProduct(Product p1) {
        lock.lock();

        try {
            while(storage.size() == max_size) {
                storageFull.await();
            }
            storage.offer(p1);

            //this will signal all consumers which are waiting to consume due to empty storage
            storageEmpty.signalAll();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public Product getProduct() {
        lock.lock();

        try {
            while(storage.size() == 0) {
                storageEmpty.await();
            }
            Product p = storage.pollFirst();

            //This will signal all producers which are waiting due to storage is full
            storageFull.signalAll();
            return p;

        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

}

package concurrency.ch02.prodcons.commons;

import concurrency.ch02.prodcons.sync.ProductStorage;

public class Producer implements  Runnable {
    private String producerID ;
    private Storage products;

    public Producer(String producerID, Storage pd)
    {
        this.producerID = producerID;
        this.products = pd;
    }

    @Override
    public void run() {

        for(int i=0; i<15; i++)
        {
            Product p = new Product();
            p.setId(i);
            p.setName("Product");
            p.setProduccerID(producerID);
            products.addProduct(p);
            System.out.println(p + " added into storage");
        }
    }

    public String getProducerID() {
        return producerID;
    }

}

package concurrency.ch02.prodcons.commons;

public interface Storage {
    public void  addProduct(Product p1);
    public Product getProduct();
}

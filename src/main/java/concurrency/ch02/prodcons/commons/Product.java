package concurrency.ch02.prodcons.commons;

public class Product {
    private int id;
    private String name;

    public String getProduccerID() {
        return produccerID;
    }

    public void setProduccerID(String produccerID) {
        this.produccerID = produccerID;
    }

    private String produccerID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Product id: %d - Producer:%s", id, produccerID);
    }
}

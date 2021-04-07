package functionais.model;

import functionais.interfaces.Clone;

public class Product implements Clone<Product> {
    public Integer id;
    public String name;
    public String category;
    public Double price;

    public Product(Integer id, String nome, String category, double price){
        this.id = id;
        this.name = nome;
        this.category = category;
        this.price = price;
    }

    @Override public String toString() {
        return  " id: " + id + ", name: " + name + ", category: " + category + ", price: " + price;
    }

    @Override public Product getClone() {
        try {
            return ((Product) super.clone());
        } catch (CloneNotSupportedException ex){
            return null;
        }
    }
}

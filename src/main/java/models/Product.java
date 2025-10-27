package models;

public class Product {

    private String name;
    private double currentPrice;

    public Product(String name, double price){
        this.name = name;
        this.currentPrice = price;
    }

    public String getName() { return name; }

    public double getPrice() { return currentPrice; }

    @Override
    public String toString() {
        return name + " | Price: " + currentPrice;
    }
}

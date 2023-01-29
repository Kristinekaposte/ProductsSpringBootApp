package com.example.productsspringboot;

import java.util.UUID;

public class Products {
    private UUID uuid;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private boolean isAvailable;


    public Products (){
    }
    public Products(String name, int quantity, double price,String description, boolean isAvailable) {
       this.uuid=UUID.randomUUID();
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.description=description;
        this.isAvailable=isAvailable;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

//    @Override
//    public String toString() {
//        return this.uniqueID+" "+ this.name+" " +this.quantity +" "+ this.price+" "+ this.description+" "+ this.isAvailable + "\n";
//    }

    @Override
    public String toString() {
        return "Products{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }


//    public static void main(String[] args) {
//        Products products =new Products("APPLE", 1, 2.3,"green apple", true);
//        System.out.println(products);
//    }
}

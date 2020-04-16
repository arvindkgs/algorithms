package com.equalexperts.shoppingcart.model;

import java.util.Objects;

public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Product ['name': "+this.name+", 'price':"+this.price+"]";
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Product && ((Product) o).name.equals(this.name) && ((Product) o).price == this.price) return true;
        else return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.price);
    }
}

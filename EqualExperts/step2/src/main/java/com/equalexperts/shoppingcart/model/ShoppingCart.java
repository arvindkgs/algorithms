package com.equalexperts.shoppingcart.model;

import com.equalexperts.shoppingcart.common.Util;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Map of Product and number of items belonging to product
    private Map<Product, Integer> products;

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        addProducts(product, 1);
    }

    // Add multiple products of same type at once
    public void addProducts(Product product, int number) {
        if (product != null && number > 0) {
            Integer count = (this.products.get(product) == null) ? 0 : this.products.get(product);
            this.products.put(product, count + number);
        }
    }

    public Integer getProductCount(Product product) {
        if (product != null)
            return (products.get(product) == null)? 0: products.get(product);
        else
            return 0;
    }

    /**
     *
     * @return totalPrice rounded to 2 decimal places
     */
    public Double getTotalPrice(){
        Double total = products.entrySet().stream().map(productEntry -> productEntry.getKey().getPrice() * productEntry.getValue()).reduce(0.0, (price1, price2) -> price1 + price2 );
        return Util.roundDouble(total * 100) / 100d;
    }
}

package com.equalexperts.shoppingcart.model;

import com.equalexperts.shoppingcart.common.Util;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Map of Product and number of items belonging to product
    private Map<Product, Integer> products;
    private TaxCalculator taxCalculator;

    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }

    private Double salesTax = 0d;

    public ShoppingCart(TaxCalculator taxCalculator) {
        this.products = new HashMap<>();
        this.taxCalculator = taxCalculator;
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
     * totalPrice is summation of (TotalItemCost + TotalSalesTax)
     * @return totalPrice rounded to 2 decimal places
     */
    public Double getTotalPrice(){
        return Util.roundDouble(getTotalItemCost() + getTotalSalesTax());
    }

    private Double getTotalItemCost() {
        Double total = products.entrySet().stream().map(productEntry -> productEntry.getKey().getPrice() * productEntry.getValue()).reduce(0.0, (price1, price2) -> price1 + price2 );
        return Util.roundDouble(total);
    }

    public Double getTotalSalesTax() {
        return taxCalculator.calculateTax(getTotalItemCost());
    }

}

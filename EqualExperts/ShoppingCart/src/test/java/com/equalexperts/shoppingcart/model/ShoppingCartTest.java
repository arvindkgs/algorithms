package com.equalexperts.shoppingcart.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {
    ShoppingCart shoppingCart;
    Product dove;
    Product axe;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart(new TaxCalculator(0d));
        dove = new Product("Dove Soap", 39.99);
        axe = new Product("Axe Deo", 99.99);
    }

    @Test
    void addProduct() {
        IntStream.range(0,5).forEach(n -> shoppingCart.addProduct(dove));
        assertEquals( 5, shoppingCart.getProductCount(dove));
    }

    @Test
    void getTotalPrice() {
        IntStream.range(0,5).forEach(n -> shoppingCart.addProduct(dove));
        assertEquals(199.95, shoppingCart.getTotalPrice());
    }

    @Test
    void addProducts() {
        shoppingCart.addProducts(dove, 2);
        shoppingCart.addProducts(axe, 2);
        assertEquals(2, shoppingCart.getProductCount(dove));
        assertEquals(2, shoppingCart.getProductCount(axe));
        assertEquals(279.96, shoppingCart.getTotalPrice());
    }

    @Test
    void getTotalSalesTax() {
        shoppingCart = new ShoppingCart(new TaxCalculator(12.5d));
        shoppingCart.addProducts(dove, 2);
        shoppingCart.addProducts(axe, 2);
        assertEquals(2, shoppingCart.getProductCount(dove));
        assertEquals(2, shoppingCart.getProductCount(axe));
        assertEquals(35.0, shoppingCart.getTotalSalesTax());
        assertEquals(314.96, shoppingCart.getTotalPrice());
    }
}
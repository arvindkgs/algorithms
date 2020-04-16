package com.equalexperts.shoppingcart.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {
    ShoppingCart shoppingCart;
    Product dove;
    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        dove = new Product("Dove", 39.99);
    }

    @Test
    void addProduct() {
        //Add 5 dove items to shopping cart
        IntStream.range(0,5).forEach(n -> shoppingCart.addProduct(dove));
        //Positive Test
        assertEquals(5, shoppingCart.getProductCount(dove));
        //Negative Test
        assertEquals(0, shoppingCart.getProductCount(null));
    }

    @Test
    void getTotalPrice() {
        //Negative Test
        assertEquals(0, shoppingCart.getTotalPrice());
        IntStream.range(0,5).forEach(n -> shoppingCart.addProduct(dove));
        //Positive Test
        assertEquals(199.95, shoppingCart.getTotalPrice());
    }

    @Test
    void addProducts() {
        //Negative Test
        shoppingCart.addProducts(dove, 0);
        assertEquals(0, shoppingCart.getProductCount(dove));
        //Positive Test
        shoppingCart.addProducts(dove, 5);
        shoppingCart.addProducts(dove, 3);
        assertEquals(8, shoppingCart.getProductCount(dove));
        assertEquals(319.92, shoppingCart.getTotalPrice());
    }
}
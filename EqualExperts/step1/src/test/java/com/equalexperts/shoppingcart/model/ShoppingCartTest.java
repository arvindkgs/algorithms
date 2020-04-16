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
    void totalPrice() {
        //Negative Test
        assertEquals(0, shoppingCart.totalPrice());
        IntStream.range(0,5).forEach(n -> shoppingCart.addProduct(dove));
        //Positive Test
        assertEquals(199.95, shoppingCart.totalPrice());
    }
}
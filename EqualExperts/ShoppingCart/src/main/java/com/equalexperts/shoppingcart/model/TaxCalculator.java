package com.equalexperts.shoppingcart.model;

import com.equalexperts.shoppingcart.common.Util;

public class TaxCalculator {
    private double salesTax;
    public TaxCalculator(double salesTax){
        this.salesTax = salesTax;
    }
    public double calculateTax(double price) {
        return Util.roundDouble(price * salesTax / 100d);
    }
}

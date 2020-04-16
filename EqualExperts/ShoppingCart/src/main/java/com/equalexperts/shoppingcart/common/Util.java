package com.equalexperts.shoppingcart.common;

public class Util {

    /**
     * Rounds given double to last two decimals as
     * round (d) where d:(0.0000-to-0.0049) => 0.00
     * round (d) where d:(0.0050-to-0.0099) => 0.01
     * NOTE: Math.round(d) where d = 0.005 => 0.00, instead of expected 0.01
     * @param d
     * @return Double
     */
    public static Double roundDouble(Double d) {
        Double floorD = Math.floor(d * 100)/100d;
        Double res = floorD;
        double diff = d - floorD;
        if (diff >= 0.0049)
            res = floorD + 0.01;
        return res;
    }
}

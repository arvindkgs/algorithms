package com.akgs.algo.arrays;

import java.util.Arrays;
import java.util.List;

class MaxDiffInProfits {
    public static void main(String[] args) {
        /**
         * Find max profits in given list of selling prices of a stock per day. 
         * These prices are listed in correct order chronologically, so you cannot sort them.
         * You can only buy and sell once
         */
        List<Integer> px = Arrays.asList(100,-129,877,-166,433,547,413,311,311,307,15,334,-58,821,335,646,697,845,-156,781,-84,675,833,182,937,-246,865,603,534,912,618,494,-73,131,28,282,412,489,902,842,259,844,720,324,-154,757,662,628,-5,163,178,-7,-18,365,303,530,744,838,626,-175,216,22,976,704,782,579,151,764,494,-28,699,718,351,959,407,256,215,952,328,631,228,711,438,753,830,28,81,410,621,543,745,714,829,457,481,136,134,50,678,-235,256);
        System.out.println("maxDifference(px) = " + maxDifference(px));
    }

    public static int maxDifference(List<Integer> px) {
        // Write your code here
        int maxDiff = 0;
        int currPeak = 0;
        for(int i=1;i<px.size();i++) {
            if (px.get(i-1) < px.get(i)){
                int diff = px.get(i) - px.get(i-1);
                if (diff > 0) {
                    if (px.get(i) > currPeak) {
                        maxDiff += diff;
                        currPeak = px.get(i);
                    }
                    else if(diff > maxDiff){
                        maxDiff = diff;
                        currPeak = px.get(i);
                    }
                }
            }
        }
        if (maxDiff < 1) {
            maxDiff = -1;
        }
        return maxDiff;
    }

}
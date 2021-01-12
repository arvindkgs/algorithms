package com.akgs.algo.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairsWhichDivideByGivenNumber {
    public static void main(String[] args) {
        //Return pairs(x,y) from integer list such that ( x + y ) mod 60 = 0 
        // x mod 60 + y mod 60 = 0
        Integer[] list = {30,30,37,23,101,21,41,19};
        //ans: (30,30), (37,23), (101,19) = 3
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> numbers = Arrays.asList(list);
        numbers.stream().map(x -> { return x % 60; }).forEach(x -> {
            int count = countMap.containsKey(x)? countMap.get(x) : 0;
            countMap.put(x, count+1);
        });
        int result = 0;
        for(int i=0;i<60;i++){
            if(countMap.containsKey(i)) {
                int number = i;
                int freq = countMap.get(i);
                if (freq > 1 && (number == 30 || number == 0)) {
                    result += freq * (freq - 1) / 2;
                } else if (countMap.containsKey(60 - number)) {
                    result++;
                    countMap.remove(60 - number);
                }
            }
        }
        System.out.println("result = " + result);
    }
}

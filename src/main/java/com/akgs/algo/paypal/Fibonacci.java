package com.akgs.algo.paypal;

import java.util.ArrayList;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        // Fibonacci series as a list
        // Fn should be recursive, should not take references as arguments, no global variables,
        // return list of fib series till n
        // 1,2,3,4,5
        // 1,1,2,3,5
        fibonacci(5, 1, 1).stream().forEach(System.out::println);
    }

    private static List<Integer> fibonacci(int upper, int curr, int prev) {
        List<Integer> list = new ArrayList<>();
        if(curr >= upper)
            return list;
        if (curr == 1){
            list.add(1);
            list.add(1);
        }
        int next = curr + prev;
        list.add(next);
        list.addAll(fibonacci(upper, next, curr));
        return list;
    }
}
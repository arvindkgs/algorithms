package com.akgs.algorithms.grokking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumSubarray {
    //https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 3, 4, 1, 5);
        int k = 2;
        int movingSum = 0;
        int maxSum = 0;
        int wStart = 0;
        for(int wEnd=0;wEnd<arr.size();wEnd++) {
            movingSum+=arr.get(wEnd);
            if(maxSum<movingSum){
                maxSum = movingSum;
            }
            if(wEnd >= k-1){
                movingSum = (movingSum - arr.get(wStart));
                wStart++;
            }
        }
        System.out.println("Max Sum = " + maxSum);
    }
}

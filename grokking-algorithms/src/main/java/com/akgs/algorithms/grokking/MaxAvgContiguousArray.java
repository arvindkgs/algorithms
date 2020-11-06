package com.akgs.algorithms.grokking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxAvgContiguousArray {
    //https://www.educative.io/courses/grokking-the-coding-interview/7D5NNZWQ8Wr
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 3, 2, 6, -1, 4, 1, 8, 2);
        int k = 5;
        float movingSum = 0;
        float maxAvg = 0;
        float movingAvg = 0;
        int wStart = 0;
        List<Float> averages = new ArrayList<>();
        for(int wEnd=0;wEnd<arr.size();wEnd++) {
            movingSum+=arr.get(wEnd);
            if(wEnd >= k-1){
                movingAvg = movingSum / k;
                movingSum = (movingSum - arr.get(wStart));
                averages.add(movingAvg);
                wStart++;
            }
            if(maxAvg<movingAvg){
                maxAvg = movingAvg;
            }
        }
        System.out.println("averages = " + averages);
    }
}

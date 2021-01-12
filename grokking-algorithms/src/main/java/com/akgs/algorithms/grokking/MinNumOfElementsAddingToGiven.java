package com.akgs.algorithms.grokking;

public class MinNumOfElementsAddingToGiven {
    //https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 1, 5, 2, 3, 2};
        int S = 7;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int wStart = 0;
        for(int wEnd=0;wEnd<arr.length;wEnd++){
            sum+=arr[wEnd];
            while(sum >= S){
                minLen = Math.min(minLen, wEnd - wStart + 1);
                sum -= arr[wStart];
                wStart++;
            }
        }
        System.out.println("minLen = " + minLen);
    }
}

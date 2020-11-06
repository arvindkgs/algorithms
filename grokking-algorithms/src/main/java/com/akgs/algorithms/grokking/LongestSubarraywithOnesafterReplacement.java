package com.akgs.algorithms.grokking;

public class LongestSubarraywithOnesafterReplacement {
    public static void main(String[] args) {
        /*
         * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, 
         * find the length of the longest contiguous subarray having all 1s.
         */
        int[] arr = new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1};
        int k=2, countZeros = 0, maxLength = 0;
        int wStart = 0;
        for(int wEnd = 0; wEnd < arr.length; wEnd++){
            if(arr[wEnd] == 0){
                countZeros++;
                while (countZeros > k) {
                    if(arr[wStart] == 0) {
                        countZeros--;
                    }
                    wStart++;
                }
            }
            maxLength = Math.max(maxLength, wEnd - wStart + 1);
        }
        System.out.println("maxLength = " + maxLength);
    }
}

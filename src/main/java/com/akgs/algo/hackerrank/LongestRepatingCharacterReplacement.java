package com.akgs.algo.hackerrank;

/**
 * Longest repeating character replacement
 * Given a string s and #operations k, find the longest repeating character sequence that can be obtained after performing k operations
 * An operation means replacing one character in the given string with any character in the English alphabet
 * Example: s = "ABAB", k = 1, Answer = 3 (AAAB or ABBB)
 */
public class LongestRepatingCharacterReplacement {
    public static void main(String[] args) {
        //aaaabcccaa , 1
        //aaaabcbbbb
        //aababbbb, 2
        //String s = "ABAB"; int k = 2;
        //String s  = "AABABBC"; int k = 1;
        //String s  = "AABABBA"; int k = 1;
        String s = "ABAB"; int k = 2;
        /*
         *  c | i | j | length | k | max
         *  A,  0,  0,   1,      1,  1
         *  B,  1,  1,   -1,     -1, 1
         *  A,  2,
         */
        int j = 0;
        int maxLength = Integer.MIN_VALUE;
        int length = 1;
        char first = s.charAt(0);
        int ops = k;
        for (int i = 1; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == first) {
                length++;
            } else {
                if (k == ops) {
                    j = i;
                }
                if (k >= 1) {
                    k--;
                    length++;
                } else {
                    if (ops > 0) {
                        k = ops - 1;
                        length = i - j - 1;
                    }
                    j = i;
                    first = s.charAt(j);
                    //aababbc, 1
                }
            }
            if(length > maxLength)
                maxLength = length;
        }
        System.out.println("maxLength = " + maxLength);
    }
}

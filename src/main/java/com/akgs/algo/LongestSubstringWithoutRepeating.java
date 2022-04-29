package com.akgs.algo;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "uqinntq"; //expected 4
        int[] charCount = new int[128];
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            charCount[r]++;
            while (charCount[r] > 1) {
                char l = s.charAt(left);
                charCount[l]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        System.out.println("Max: " + max);
    }

}

package com.akgs.algorithms.grokking;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringwithSameLettersAfterReplacement {
    public static void main(String[] args) {
        /*
         * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
         * find the length of the longest substring having the same letters after replacement.
         */
        String str = "abbcb"; int k = 1;
        Map<Character, Integer> letterFrequencyMap = new LinkedHashMap<>();
        int currMaxLetterFreq = 0, wStart = 0, maxLength = 0;
        for(int wEnd = 0; wEnd < str.length(); wEnd++) {
            Character rightChar = str.charAt(wEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0)+1);
            currMaxLetterFreq = Math.max(currMaxLetterFreq, letterFrequencyMap.get(rightChar));
            if(wEnd - wStart + 1 - currMaxLetterFreq > k) {
                Character leftChar = str.charAt(wStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.getOrDefault(leftChar, 0)-1);
                wStart++;
            }
            maxLength = Math.max(maxLength, wEnd-wStart+1);
        }
        System.out.println("maxLength = " + maxLength);
    }
}

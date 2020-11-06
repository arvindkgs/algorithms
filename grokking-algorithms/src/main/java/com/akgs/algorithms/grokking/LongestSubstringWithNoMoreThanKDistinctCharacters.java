package com.akgs.algorithms.grokking;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoMoreThanKDistinctCharacters {
    public static void main(String[] args) {
        String str = "abcac";
        int k = 2;
        int unique = 0;
        int maxLength = 0, maxStart = 0, maxEnd = 0;
        int wStart = 0;
        char[] chars = str.toCharArray();
        Map<Character, Integer> recent = new HashMap<>();
        for(int wEnd=0; wEnd < chars.length;wEnd++){
            if(recent.get(chars[wEnd]) == null && unique >= k){
                wStart = recent.remove(chars[wStart])+1;
            }
            else if(recent.get(chars[wEnd]) == null)
                    unique++;
            recent.put(chars[wEnd], wEnd);
            if(wEnd - wStart +1 > maxLength){
                maxLength = wEnd - wStart +1;
                maxStart = wStart;
                maxEnd = wEnd;
            }
        }
        System.out.println("maxLength = " + maxLength+", subset: "+str.substring(maxStart, maxEnd+1));
    }
}

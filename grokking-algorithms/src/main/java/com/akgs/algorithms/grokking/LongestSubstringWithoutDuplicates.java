package com.akgs.algorithms.grokking;

import java.util.LinkedList;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String str = "cccab";
        char[] chars = str.toCharArray();
        int maxLength = 0, start = 0, end = 0, wStart = 0;
        LinkedList<Character> window = new LinkedList<>();
        int wEnd = 0;
        for(wEnd = 0; wEnd < chars.length; wEnd++){
            char c = chars[wEnd];
            if(window.contains(c)){
                if (maxLength < (wEnd - wStart)){
                    maxLength = wEnd - wStart;
                    start = wStart;
                    end = wEnd;
                }
                wStart = wEnd;
                window.clear();
                window.push(c);
            }
            else{
                window.push(c);
            }
        }
        if (maxLength < (wEnd - wStart) && window.size() > 0){
            maxLength = wEnd - wStart;
            start = wStart;
            end = wEnd;
        }
        System.out.println("str = " + str.substring(start, end));
    }
}

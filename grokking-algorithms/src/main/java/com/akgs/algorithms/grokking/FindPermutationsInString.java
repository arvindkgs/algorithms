package com.akgs.algorithms.grokking;

import java.util.*;
import java.util.stream.Collectors;

public class FindPermutationsInString {
    public static void main(String[] args) {
        //Find if a string contains any possible permutations of search string
//        String str = "aaacb", pattern = "aacb";
//        String str ="oidbcaf", pattern="abc";
//        String str = "odicf", pattern = "dc";
//        String str ="bcdxabcdy", pattern="bcdyabcdx";
        String str ="aaacb", pattern="aabc";
//        List<Character> patternList = pattern.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
//        List<Character> orgList = new ArrayList<>(patternList);
//        for(int i=0;i<str.length();i++){
//            Character c = str.charAt(i);
//            if(patternList.contains(c)){
//                int j=i;
//                while(j<str.length() && patternList.size() > 0 && patternList.contains(str.charAt(j))){
//                    patternList.remove(patternList.indexOf(str.charAt(j)));
//                    j++;
//                }
//                if(patternList.size() == 0){
//                    break;
//                }
//                patternList.clear();
//                patternList.addAll(orgList);
//            }
//        }
        System.out.println("Pattern found: "+ findPermutation(str, pattern));
    }
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == charFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }
}

package com.akgs.algorithms.grokking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
    public static void main(String[] args) {
        List<Integer> indexList = findAnagramsList("abbcabc", "abc");
        indexList.stream().forEach(System.out::println);
    }

    private static List<Integer> findAnagramsList(String str, String pattern) {
        Map<Character, Integer> findLettersMap = new HashMap<>();
        for(Character c : pattern.toCharArray()){
            findLettersMap.put(c, findLettersMap.getOrDefault(c, 0)+1);
        }
        int distinct = findLettersMap.size();
        List<Integer> result = new ArrayList<>();
        int matched = 0;
        Integer wStart = 0;
        for(int wEnd = 0; wEnd < str.length(); wEnd++){
            Character rightChar = str.charAt(wEnd);
            if(findLettersMap.containsKey(rightChar)){
                findLettersMap.put(rightChar, findLettersMap.get(rightChar) - 1);
                if(findLettersMap.get(rightChar) == 0){
                    matched++;
                }
                if(matched == distinct){
                    result.add(wStart);
                }
            }
            
            if(wEnd >= pattern.length()-1){
                Character leftChar = str.charAt(wStart++);
                if(findLettersMap.containsKey(leftChar)){
                    if(findLettersMap.get(leftChar) == 0)
                        matched--;
                    findLettersMap.put(leftChar, findLettersMap.get(leftChar)+1);
                }
            }
        }
        return result;
    }
}

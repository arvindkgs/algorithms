package com.akgs.algorithms.grokking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordsConcatenation {
    /**
     * Given a string and a list of words, 
     * find all the starting indices of substrings in the given string
     * that are a concatenation of all the given words exactly once
     * without any overlapping of words. It is given that all words are of the same length.
     * example: 
     * Input: String="catfoxcat", Words=["cat", "fox"]
     * Output: [0, 3]
     * Explanation: The two substring containing both the words are "catfox" & "foxcat".
     */
    public static void main(String[] args) {
        String str = "catasdfoxcat";
        String[] words = new String[]{"cat","fox"};
        for(String s: findWordsConcatenation(str, words)){
            System.out.println(s);
        }
    }
    
    static class TrieNode {
        char c;
        TrieNode[] children;
        boolean leaf = true;
        boolean matched = false;
        TrieNode(){
            children = new TrieNode[26];
        }
        TrieNode(char c){
            this.c = c;
            children = new TrieNode[26];
        }
        TrieNode add(char c){
            leaf = false;
            if(children[c - 97] == null){
                children[c - 97] = new TrieNode(c);
            }
            return children[c - 97];
        }
        TrieNode add(String s){
            char[] chars = s.toCharArray();
            TrieNode instance = this;
            for(char c: chars){
                instance = instance.add(c);
            }
            return this;
        }
    }

    private static List<String> findWordsConcatenation(String str, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        root.leaf = false;
        int fullLength = 0;
        for(String word:words) {
            root.add(word);
            fullLength += word.length();
        }
        int wStart = 0, matches = 0;
        TrieNode curr = root;
        for(int wEnd = 0;wEnd < str.length(); wEnd++){
            char rightChar = str.charAt(wEnd);
            if(curr.children[rightChar-97] != null){
                curr = curr.children[rightChar-97];
                if(curr.leaf){
                    matches++;
                    if(matches == words.length){
                        result.add(str.substring(wStart,wStart+fullLength));
                    }
                    curr = root;
                }
            }
            else{
                matches = 0;
                curr = root;
            }
            if(wEnd - wStart + 1 >= fullLength){
                char leftChar = str.charAt(wStart);
                TrieNode tmp = root;
                int bakWStart = wStart;
                while(tmp.children[leftChar-97]!=null){
                    wStart++;
                    tmp = tmp.children[leftChar-97];
                    leftChar=str.charAt(wStart);
                }
                if(wStart != bakWStart){
                    matches--;
                }
                while(wStart<wEnd && root.children[str.charAt(wStart)-97]== null)wStart++;
            }
        }
        return result;
    }
}

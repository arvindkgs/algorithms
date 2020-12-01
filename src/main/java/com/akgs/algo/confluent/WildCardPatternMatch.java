package com.akgs.algo.confluent;

public class WildCardPatternMatch {
    public static void main(String[] args){
        System.out.println(isMatch("cat","c*t"));
    }

    private static boolean isMatch(String given, String pattern) {
        boolean match = false;
        if(pattern.equalsIgnoreCase("*"))
            return true;
        int gp = 0, pp = 0;
        while(gp != -1 && gp < given.length() && pp != -1 && pp < pattern.length()){
            if(pattern.charAt(pp) == '*'){
               // while(pp < pattern.length() && pattern.charAt(pp) !)
            }
        }
        return match;
    }
}

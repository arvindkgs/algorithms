package com.akgs.algo.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindWordInSentance {
    public static void main(String[] args) {
        String S1 = "Try this test test sentance.";
        String S2 = "test";
        List<String> tokens = new ArrayList<String>();
        tokens.add(S2);
        String patternString = "\\b(" + tokens.stream().collect(Collectors.joining("|")) + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(S1);

        if (matcher.find()) {
            System.out.println("Found at index: "+matcher.start());
        }
    }
}

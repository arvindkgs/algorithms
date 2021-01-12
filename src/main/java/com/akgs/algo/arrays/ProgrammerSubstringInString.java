package com.akgs.algo.arrays;

import java.util.Arrays;
import java.util.List;

public class ProgrammerSubstringInString {
        public static void main(String[] args) {
            List<Integer> px = Arrays.asList();
            String s = "programmer";
            StringBuffer sb = new StringBuffer();
            String test = "asdsadprogrammerxptrogrammer";
            String duplicates = "rm";
            for (Character c : test.toCharArray()) {
                if (s.indexOf(c) != -1 && ((duplicates.indexOf(c) == -1 && sb.indexOf(c+"") == -1)
                        || (c == 'r' && (sb.toString().length() - sb.toString().replace("r", "").length() < 3))
                        || ( c == 'm' && ((sb.toString().length() - sb.toString().replace("m", "").length() < 2))))) {
                    sb.append(c);
                }
                if (sb.toString().length() == 10) {
                    sb.setLength(0);
                    System.out.println("found");
                }
            }
        }

    }

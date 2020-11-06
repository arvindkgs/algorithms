package com.akgs.algo.twothreepointer;

import java.util.*;
import java.util.stream.Collectors;

public class FindTripletsInArray {
    public static void main(String[] args) {
        /**
         * Find all triplets in given array whose sum matches given total
         */
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        List<Set<Integer>> result = new ArrayList<>();
        if(numbers.size() < 3){
            System.out.println("Invalid input");
        }
        int lp = 0, up = 0, total = 9;
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() - 2; i++) {
            lp = i + 1;
            up = numbers.size() - 1;
            while (lp < up) {
                if (numbers.get(i) + numbers.get(lp) + numbers.get(up) == total) {
                    Set<Integer> solution = new HashSet<>();
                    solution.add(numbers.get(i));
                    solution.add(numbers.get(lp));
                    solution.add(numbers.get(up));
                    result.add(solution);
                    break;
                }
                else if (numbers.get(i) + numbers.get(lp) + numbers.get(up) < total)
                    lp++;

                else
                    up--;
            }
        }

        for (Set solution : result) {
            System.out.println(solution.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
    }
}

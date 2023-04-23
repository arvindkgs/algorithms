package com.akgs.algo.knapsack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ribbons {
    public static void main(String[] args) {
        System.out.println(solution(List.of(6, 5, 1, 4, 3, 6, 1, 9, 6, 5).stream().mapToInt(i->i).toArray(), 21));
    }

    public static int solution(int[] a, int k) {
        int solution = 0;
        final IntStream stream = Arrays.stream(a);
        final Stream<Integer> integerStream = stream.boxed();
        int sum = integerStream.mapToInt(i -> i).sum();
        if (sum >= k) {
            return 1;
        }
        int max = sum/k;
        for (int i=max;i>1;i--) {
            int count = 0;
            for (int j=0;j<a.length;j++) {
                count += a[j] /i;
            }
            if (count >= k)
                return i;
        }
        if (sum > k) {
            return 1;
        }
        return solution;
    }
}

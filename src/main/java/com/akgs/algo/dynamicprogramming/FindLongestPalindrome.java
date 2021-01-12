package com.akgs.algo.dynamicprogramming;

public class FindLongestPalindrome {
    public static void main(String[] args) {
        String S1 = "abbab";
        int N = 5;
        int n;
        int maxLength;
        boolean table[][];
        String str;
        int[] result = new int[N];
        for(int l=1;l<=N;l++) {
            str = S1.substring(0,l);
            n = str.length();
            maxLength = 0;
            table = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                table[i][i] = true;
                maxLength = 1;
            }
            for (int i = 0; i < n - 1; i++) {
                if (S1.charAt(i) == S1.charAt(i + 1)) {
                    table[i][i + 1] = true;
                    maxLength = 2;
                }
            }
            //k = size of word to check
            for (int k = 3; k <= n; k++) {
                for (int i = 0; i < n - k + 1; i++) {
                    int j = i + k - 1;
                    if (table[i + 1][j - 1]
                            && str.charAt(i) == str.charAt(j)) {
                        table[i][j] = true;
                        if (k > maxLength) {
                            maxLength = k;
                        }
                    }
                }
            }
            result[l-1] = maxLength;
        }
        for(int i=0;i<N;i++){
            System.out.println( result[i]);
        }
    }
}

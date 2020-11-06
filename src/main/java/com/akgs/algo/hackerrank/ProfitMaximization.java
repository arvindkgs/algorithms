package com.akgs.algo.hackerrank;

import java.io.IOException;
/**
 * Hackerrank : https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/avatar-and-his-quest-d939b13f/description/
 * You have to travel to different villages to make some profit.
 * In each village, you gain some profit. But the catch is, from a particular village i, you can only move to a village j if and only if  and the profit gain from village j is a multiple of the profit gain from village i.
 *
 * You have to tell the maximum profit you can gain while traveling.
 *
 * Input format
 *
 * The first line contains a single integer N denoting the total number of villages.
 * The second line contains N space-separated integers, each denoting the profit gain  from village i.
 * Output format
 *
 * Print the maximum profit you can gain.
 */
public class ProfitMaximization {
    static int maxProfits[];
    public static void main(String[] args) throws IOException {
        int[] P_i = new int[]{1,2,3,4,8,9};
        int N = P_i.length;
        int out_ = solve(N, P_i);
        System.out.println(out_);
    }
    static int solve(int N, int[] P_i){
        maxProfits = new int[N];
        int maxProfit = 0;
        for(int i=N-1;i>0;i--){
            int profit = traverse(P_i, N, i);
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
    static int traverse(int[] array, int N, int i){
        if(i==0){
            return array[0];
        }
        if(maxProfits[i] != 0)
            return maxProfits[i];
        int maxProfit = array[i];
        for(int j=i-1;j>=0;j--){
            if(i!=j && array[i]%array[j] == 0){
                if(maxProfits[j] == 0){
                    maxProfits[j] = traverse(array, N, j);
                }
                if(maxProfit < maxProfits[j] + array[i]){
                    maxProfit = maxProfits[j] + array[i];
                }
            }
        }
        return maxProfit;
    }
}

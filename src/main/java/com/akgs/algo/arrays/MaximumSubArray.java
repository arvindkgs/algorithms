package com.akgs.algo.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class MaximumSubArray {
  public static void main(String[] args) {
    final List<Integer> integers = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
    final int[] ints = new int[integers.size()];
    for (int i = 0; i < integers.size(); i++) {
      ints[i] = integers.get(i);
    }
    System.out.println("Ans: " + maxSubArray(ints));
  }

  public static int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int curr = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      curr += nums[i];
      if (curr > max) {
        max = curr;
      }
      if (curr < 0) {
        curr = 0;
      }
    }
    int rl_max = max;

    curr = 0;
    max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      curr += nums[i];
      if (curr > max) {
        max = curr;
      }
      if (curr < 0) {
        curr = 0;
      }
    }
    return Math.max(max, rl_max);
  }
}

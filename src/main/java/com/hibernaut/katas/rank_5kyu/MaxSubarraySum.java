package com.hibernaut.katas.rank_5kyu;

/**
 *The maximum sum subarray problem consists in finding
 * the maximum sum of a contiguous subsequence in an array or list of integers:
 *
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 *
 * Easy case is when the list is made up of only positive numbers
 * and the maximum sum is the sum of the whole array.
 * If the list is made up of only negative numbers, return 0 instead.
 *
 * Empty list is considered to have zero greatest sum.
 * Note that the empty list or array is also a valid sublist/subarray.
 */

public class MaxSubarraySum {
    public static int sequence(int[] arr) {
        int maxSum = 0;
        int newMaxSum;

        for (int i = 0; i < arr.length; i++) {
            newMaxSum = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                newMaxSum += arr[j];

                if(newMaxSum > maxSum) {
                    maxSum = newMaxSum;
                }
            }
        }

        return maxSum;
    }
}

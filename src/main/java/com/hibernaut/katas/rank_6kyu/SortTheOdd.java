package com.hibernaut.katas.rank_6kyu;

import java.util.Arrays;

/**
 * Task
 *
 * You will be given an array of numbers. You have to sort the odd numbers in ascending order
 * while leaving the even numbers at their original positions.
 * Examples
 *
 * [7, 1]  =>  [1, 7]
 * [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
 * [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        int[] sortedOddNumbers = Arrays.stream(array).filter(i -> i % 2 != 0).sorted().toArray();
        final int[] i = {0};

        return Arrays.stream(array)
                .map(e -> {
                    if(e % 2 != 0 ) {
                        e = sortedOddNumbers[i[0]];
                        i[0]++;
                    }
                    return e;
                })
                .toArray();
    }
}

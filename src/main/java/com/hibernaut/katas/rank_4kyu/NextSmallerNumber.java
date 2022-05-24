package com.hibernaut.katas.rank_4kyu;

import java.util.Arrays;
import java.util.Collections;

/**
 * Write a function that takes a positive integer and returns
 * the next smaller positive integer containing the same digits.
 *
 * For example:
 *
 * nextSmaller(21) == 12
 * nextSmaller(531) == 513
 * nextSmaller(2071) == 2017
 *
 * Return -1 (for Haskell: return Nothing, for Rust: return None),
 * when there is no smaller number that contains the same digits.
 * Also return -1 when the next smaller number with the same digits would require
 * the leading digit to be zero.
 *
 * nextSmaller(9) == -1
 * nextSmaller(111) == -1
 * nextSmaller(135) == -1
 * nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
 *
 * some tests will include very large numbers.
 * test data only employs positive integers.
 */

public class NextSmallerNumber {
    public static long nextSmaller(long n) {
        if(n < 10) {
            return -1;
        }

        String[] number = Long.toString(n).split("");

        int[] digitsArray = Arrays.stream(number)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = digitsArray.length - 2; i >= 0; i--) {
            if(swapWithNearestSmallestDigit(digitsArray, i)) {
                Integer[] tempDigitsArray = Arrays.stream(digitsArray)
                        .boxed()
                        .toArray(Integer[]::new);

                Arrays.sort(tempDigitsArray, i + 1, digitsArray.length, Collections.reverseOrder());

                digitsArray = Arrays.stream(tempDigitsArray)
                        .mapToInt(Integer::intValue)
                        .toArray();
                break;
            }
        }

        long nearestSmallestNumber = Long.parseLong(Arrays.stream(digitsArray)
                .mapToObj(String::valueOf)
                .reduce(String::concat)
                .get());

        if(nearestSmallestNumber == n) {
            return -1;
        }

        return  nearestSmallestNumber;
    }

    private static boolean swapWithNearestSmallestDigit(int[] array, int index) {
        int temp = -1;
        int nearestSmallestNumberIndex = 0;

        for (int i = index + 1; i < array.length; i++) {
            if(array[i] < array[index]) {
                if (!(index == 0 && array[i] == 0)) {
                    temp = array[i];
                    nearestSmallestNumberIndex = i;
                }
            }
        }

        if(temp >= 0) {
            array[nearestSmallestNumberIndex] = array[index];
            array[index] = temp;
            return true;
        }

        return false;
    }
}

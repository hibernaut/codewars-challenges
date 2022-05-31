package com.hibernaut.katas.rank_4kyu;

import java.math.BigInteger;
import static java.math.BigInteger.valueOf;
import static java.math.BigInteger.ZERO;

/**
 * Given two numbers: 'left' and 'right' (1 <= 'left' <= 'right' <= 200000000000000)
 * return sum of all '1' occurencies in binary representations of numbers between
 * 'left' and 'right' (including both)
 *
 * Example:
 * countOnes 4 7 should return 8, because:
 * 4(dec) = 100(bin), which adds 1 to the result.
 * 5(dec) = 101(bin), which adds 2 to the result.
 * 6(dec) = 110(bin), which adds 2 to the result.
 * 7(dec) = 111(bin), which adds 3 to the result.
 * So finally result equals 8.
 * WARNING: Segment may contain billion elements, to pass this kata, your solution
 * cannot iterate through all numbers in the segment!
 */

public class CountOnesInSegment {
    public static BigInteger countOnes(long left, long right) {
        return count(right).subtract(count(left - 1));
    }

    private static BigInteger count(long b) {
        if(b == 0L) return ZERO;
        int l = (int) (Math.log(b) / Math.log(2));
        long p = 1L << l;
        return valueOf(l).multiply(valueOf(p / 2))
                .add(valueOf(1 + b - p))
                .add(count(b - p));
    }
}

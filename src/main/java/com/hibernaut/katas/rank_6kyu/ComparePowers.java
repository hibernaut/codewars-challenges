package com.hibernaut.katas.rank_6kyu;

/**
 * You certainly can tell which is the larger number between 210 and 215.
 * <p>
 * But what about, say, 210 and 310? You know this one too.
 * <p>
 * Things tend to get a bit more complicated with both different bases and exponents:
 * which is larger between 39 and 56?
 * <p>
 * Well, by now you have surely guessed that you have to build a function to compare powers,
 * returning -1 if the first member is larger, 0 if they are equal, 1 otherwise;
 * powers to compare will be provided in the [base, exponent] format:
 * <p>
 * comparePowers(new int[]{2, 10}, new int[]{2, 15}) ==  1;
 * comparePowers(new int[]{2, 10}, new int[]{3, 10}) ==  1;
 * comparePowers(new int[]{2, 10}, new int[]{2, 10}) ==  0;
 * comparePowers(new int[]{3,  9}, new int[]{5,  6}) == -1;
 * comparePowers(new int[]{7,  7}, new int[]{5,  8}) == -1;
 * Only positive integers will be tested, including bigger numbers - you are warned now,
 * so be diligent try to implement an efficient solution not to drain too much on CW resources ;)!
 */

public class ComparePowers {
    public static int comparePowers(int[] number1, int[] number2) {
        return Double.compare(Math.log(number2[0]) * number2[1], Math.log(number1[0]) * number1[1]);
    }
}

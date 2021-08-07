package com.hibernaut.katas.rank_6kyu;

/**
 * Some numbers have funny properties. For example:
 * <p>
 * 89 --> 8¹ + 9² = 89 * 1
 * <p>
 * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
 * <p>
 * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 * <p>
 * Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
 * <p>
 * we want to find a positive integer k, if it exists, such as the sum of the digits of n taken to the successive powers of p is equal to k * n.
 * <p>
 * In other words:
 * <p>
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
 * <p>
 * If it is the case we will return k, if not return -1.
 * <p>
 * Note: n and p will always be given as strictly positive integers.
 * <p>
 * digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1
 * digPow(92, 1) should return -1 since there is no k such as 9¹ + 2² equals 92 * k
 * digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
 * digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 **/

public class PlayingWithDigits {
    public static long digPow(int n, int p) {
        // Create temporary variable with string value of the number
        String temp = String.valueOf(n);
        long sum = 0;

        // Find sum of the number' digits powers
        for (int i = 0; i < temp.length(); i++) {
            sum += Math.pow(Integer.parseInt(String.valueOf(temp.charAt(i))), p + i);
        }

        // If sum is divided by number entirely, return quotient
        if (sum % n == 0) {
            return sum / n;
        } else {
            return -1;
        }
    }
}

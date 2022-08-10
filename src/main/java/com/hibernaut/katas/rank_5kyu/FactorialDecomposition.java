package com.hibernaut.katas.rank_5kyu;

import java.util.stream.IntStream;

/**
 * The aim of the kata is to decompose n! (factorial n) into its prime factors.
 * <p>
 * Examples:
 * <p>
 * n = 12; decomp(12) -> "2^10 * 3^5 * 5^2 * 7 * 11"
 * since 12! is divisible by 2 ten times, by 3 five times, by 5 two times and by 7 and 11 only once.
 * <p>
 * n = 22; decomp(22) -> "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19"
 * <p>
 * n = 25; decomp(25) -> 2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23
 * Prime numbers should be in increasing order. When the exponent of a prime is 1 don't put the exponent.
 * <p>
 * Notes
 * <p>
 * the function is decomp(n) and should return the decomposition of n!
 * into its prime factors in increasing order of the primes, as a string.
 * factorial can be a very big number (4000! has 12674 digits, n can go from 300 to 4000).
 * In Fortran - as in any other language - the returned string is not permitted
 * to contain any redundant trailing whitespace: you can use dynamically allocated character strings.
 */

public class FactorialDecomposition {
    public static String decompose(int n) {
        StringBuilder result = new StringBuilder();
        int exponent = 0;
        int remainder;

        int[] primes = IntStream.rangeClosed(2, n)
                .filter(y -> IntStream.rangeClosed(2, (int) Math.sqrt(y))
                        .noneMatch(i -> y % i == 0))
                .toArray();

        for (int i = 0; i < primes.length; i++) {
            for (int j = 2; j <= n; j++) {
                remainder = j;
                while (remainder % primes[i] == 0) {
                    exponent++;
                    remainder /= primes[i];
                }
            }

            result.append(primes[i]);

            if (exponent > 1) {
                result.append("^").append(exponent);
            }

            if (i < primes.length - 1) {
                result.append(" * ");
            }

            exponent = 0;
        }

        return result.toString();
    }
}

package com.hibernaut.katas.rank_6kyu;

import java.util.stream.IntStream;

import static java.lang.Math.sqrt;
import static java.lang.Math.round;

/**
 * Define a function that takes an integer argument and returns a logical value
 * true or false depending on if the integer is a prime.
 * Per Wikipedia, a prime number ( or a prime ) is a natural number
 * greater than 1 that has no positive divisors other than 1 and itself.
 * Requirements
 * You can assume you will be given an integer input.
 * You can not assume that the integer will be only positive.
 * You may be given negative numbers as well ( or 0 ).
 * NOTE on performance: There are no fancy optimizations required, but still
 * the most trivial solutions might time out. Numbers go up to 2^31 ( or similar, depending on language ).
 * Looping all the way up to n, or n/2, will be too slow.
 * Example
 * is_prime(1)   false
 * is_prime(2)   true
 * is_prime(-1)  false
 */

public class IsNumberPrime {
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        } else if (num > 3) {
            return IntStream.iterate(2, i -> i + 1).limit(round(sqrt(num)))
                    .noneMatch(x -> num % x == 0);
        }

        return true;
    }
}

package com.hibernaut.katas.rank_6kyu;

/**
 * In this Kata, you will be given a number and your task will be to return the nearest prime number.
 * <p>
 * solve(4) = 3. The nearest primes are 3 and 5. If difference is equal, pick the lower one.
 * solve(125) = 127
 * <p>
 * We'll be testing for numbers up to 1E10. 500 tests.
 * <p>
 * More examples in test cases.
 * <p>
 * Good luck!
 */

public class SimpleNearestPrime {
    //Main method
    public static long solve(long n) {
        for (int i = 0; ; i++) {
            if (isPrime(n - i)) return n - i;
            if (isPrime(n + i)) return n + i;
        }
    }

    //Method which determines if the number is prime
    public static boolean isPrime(long number) {
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return number > 1;
    }
}

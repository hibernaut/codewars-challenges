package com.hibernaut.katas;

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
        long inputNumber = n;
        long firstPrime = findPrime(inputNumber, false);
        long secondPrime = findPrime(inputNumber, true);

        if ((inputNumber - firstPrime) > (secondPrime - inputNumber)) {
            return secondPrime;
        } else if ((inputNumber - firstPrime) < (secondPrime - inputNumber)) {
            return firstPrime;
        }

        return firstPrime;
    }

    //Method which finds nearest prime number in choosed direction on number line
    public static long findPrime(long inputNumber, boolean flag) {
        long number = inputNumber;
        long prime = 0;

        while (prime == 0) {
            if (isPrime(number)) {
                prime = number;
            }

            if (flag) {
                number++;
            } else {
                number--;
            }
        }

        return prime;
    }

    //Method which determines if the number is prime
    public static boolean isPrime(long number) {
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve(11L));
    }
}

package com.hibernaut.katas.rank_5kyu;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * "If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Finish the solution so that it returns the sum of all the multiples
 * of 3 or 5 below the number passed in."
 * <p>
 * The enhanced task
 * This time it is not only about the multiples of 3 or 5.
 * This time you will get not only the numberlimit, but also a whole array of primes.
 * Your task is to find every number that
 * <p>
 * is below the limit, and
 * is a multiple of one or more primes in the array.
 * Then (as usual) return the sum of those numbers.
 * <p>
 * Examples
 * If you get 10 as limit, and [ 2, 3 ] as primes, you should return
 * the sum of 2, 3, 4, 6, 8, 9, which is 32. Even though 6 is a multiple of 2 and 3 as well,
 * you should count every number only once. 10 is not in the solution,
 * since we are looking for numbers below the limit.
 * <p>
 * If you get 10 as limit, and [ 11, 13 ] as primes, your code should return 0,
 * since there are no multiples of 11 or 13 below 10.
 * <p>
 * Additional information
 * Your inputs:
 * a string containing a positive, whole number
 * an array of Integers, containing positive prime numbers
 * Your output: a string containing a positive, whole number (aka your solution)
 * You can expect the inputs to be valid, so:
 * the limit will contain only digits (0-9)
 * the array of primes will contain only primes, there will be no duplicates
 * although the limit can be really big, up to 30 digits
 * also your array can contain up to 20 different primes
 * (this includes the possibility of an empty array as well)
 * I think this task is more about logic than performance,
 * but I still recommend you to optimalize your code
 */

public class PrimeMultiples {
    public static String findThem(String numberLimit, int[] primes) {
        BigInteger maxNumber = (new BigInteger(numberLimit)).subtract(BigInteger.ONE);
        BigInteger[] primeFactors = Arrays.stream(primes)
                .mapToObj(BigInteger::valueOf)
                .toArray(BigInteger[]::new);

        return calculate(primeFactors, 0, BigInteger.ONE.negate(), BigInteger.ONE, maxNumber).toString();
    }

    private static BigInteger calculate(BigInteger[] primeFactors, int index, BigInteger sign, BigInteger value, BigInteger maxNumber) {
        if(index == primeFactors.length) {
            return value == BigInteger.ONE ? BigInteger.ZERO : sumFactors(value, maxNumber).multiply(sign);
        }

        else {
            BigInteger a = calculate(primeFactors, index + 1, sign, value, maxNumber);
            BigInteger b = calculate(primeFactors, index + 1, sign.negate(), value.multiply(primeFactors[index]), maxNumber);
            return a.add(b);
        }
    }

    private static BigInteger sumFactors(BigInteger value, BigInteger maxNumber) {
        return (maxNumber.divide(value).add(BigInteger.ONE)).multiply(maxNumber.divide(value))
                .divide(BigInteger.TWO)
                .multiply(value);
    }
}

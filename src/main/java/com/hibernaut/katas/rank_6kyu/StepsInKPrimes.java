package com.hibernaut.katas.rank_6kyu;

import java.util.ArrayList;
import java.util.List;

/**
 * A natural number is called k-prime if it has exactly k prime factors, counted with multiplicity.
 * <p>
 * A natural number is thus prime if and only if it is 1-prime.
 * <p>
 * Examples of k-primes:
 * k = 2 -> 4, 6, 9, 10, 14, 15, 21, 22, …
 * k = 3 -> 8, 12, 18, 20, 27, 28, 30, …
 * k = 5 -> 32, 48, 72, 80, 108, 112, …
 * <p>
 * The k-prime numbers are not regularly spaced. For example:
 * between 2 and 50 we have the following 2-primes:
 * <p>
 * [4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49]
 * <p>
 * The steps between two k-primes of this list are 2, 3, 1, 4, 1, 6, 1, 3, 1, 7, 1, 1, 3, 1, 7, 3.
 * Task
 * <p>
 * We will write a function kprimes_step(k, step, start, nd) with parameters:
 * <p>
 * k (integer > 0) which indicates the type of k-primes we are looking for,
 * <p>
 * step (integer > 0) which indicates the step we want to find between two k-primes,
 * <p>
 * start (integer >= 0) which gives the start of the search (start inclusive),
 * <p>
 * nd (integer >= start) which gives the end of the search (nd inclusive)
 * <p>
 * In the example above kprimes_step(2, 2, 0, 50) will return [[4, 6], [33, 35]]
 * which are the pairs of 2-primes between 2 and 50 with a 2 steps.
 * <p>
 * So this function should return an array of all the pairs (or tuples)
 * of k-prime numbers spaced with a step of step between the limits start, nd. This array can be empty.
 * Note (Swift)
 * <p>
 * When there is no pair instead of returning an empty array, return nil
 * <p>
 * kprimes_step(5, 20, 0, 50) => nil
 * <p>
 * Examples:
 * <p>
 * kprimes_step(2, 2, 0, 50) => [[4, 6], [33, 35]]
 * kprimes_step(6, 14, 2113665, 2113889) => [[2113722, 2113736]])
 * kprimes_step(2, 10, 0, 50) => [[4, 14], [15, 25], [25, 35], [39, 49]]
 * kprimes_step(5, 20, 0, 50) => []
 */

public class StepsInKPrimes {
    public static List<long[]> kprimesStep(int k, int step, long start, long nd) {
        List<long[]> kPrimes = new ArrayList<>();

        for (long i = start; i < nd - step + 1; i++) {
            if (countPrimeFactors(i) == k) {
                if (countPrimeFactors(i + step) == k) {
                    kPrimes.add(new long[]{i, i + step});
                }
            }
        }

        return kPrimes;
    }

    public static int countPrimeFactors(long number) {
        int primefactors = 0;

        while (number % 2 == 0 && number != 0) {
            number /= 2;
            primefactors += 1;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                number /= i;
                primefactors += 1;
            }
        }

        if(number > 2) {
            primefactors += 1;
        }

        return primefactors;
    }
}

package com.hibernaut.katas.rank_4kyu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of positive or negative integers
 * <p>
 * I= [i1,..,in]
 * <p>
 * you have to produce a sorted array P of the form
 * <p>
 * [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij] ...]
 * <p>
 * P will be sorted by increasing order of the prime numbers.
 * The final result has to be given as a string in Java, C#, C, C++ and as an array
 * of arrays in other languages.
 * Example:
 * <p>
 * I = {12, 15}; // result = "(2 12)(3 27)(5 15)"
 * <p>
 * [2, 3, 5] is the list of all prime factors of the elements of I, hence the result.
 * <p>
 * Notes:
 * <p>
 * It can happen that a sum is 0 if some numbers are negative!
 * <p>
 * Example: I = [15, 30, -45] 5 divides 15, 30 and (-45) so 5 appears in the result,
 * the sum of the numbers for which 5 is a factor is 0 so we have [5, 0] in the result amongst others.
 * <p>
 * In Fortran - as in any other language - the returned string is not permitted
 * to contain any redundant trailing whitespace: you can use dynamically allocated character strings.
 */

public class SumByFactors {
    public static String sumOfDivided(int[] l) {
        boolean hasDividend = false;
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        int max;

        Arrays.sort(l);

        max = Math.max(Math.abs(l[l.length - 1]), Math.abs(l[0]));

        Map<Integer, Integer> factorsSum = findPrimeFactors(max);
        Set<Integer> keySet = new TreeSet<>(factorsSum.keySet());

        for (Integer number : keySet) {
            for (int value : l) {
                if (value % number == 0) {
                    hasDividend = true;
                    sum += value;
                }
            }

            if (!hasDividend) {
                factorsSum.remove(number);
            } else {
                factorsSum.put(number, sum);
            }

            sum = 0;
            hasDividend = false;
        }

        for (Map.Entry<Integer, Integer> pair : factorsSum.entrySet()) {
            builder.append("(").append(pair.getKey()).append(" ").append(pair.getValue()).append(")");
        }


        return builder.toString();
    }

    private static Map<Integer, Integer> findPrimeFactors(int max) {
        Map<Integer, Integer> primeFactors = new TreeMap<>();

        List<Integer> numbers = IntStream.range(1, max + 1)
                .filter(SumByFactors::isPrime)
                .boxed()
                .collect(Collectors.toList());

        for (Integer number : numbers) {
            primeFactors.put(number, 0);
        }

        return primeFactors;
    }

    private static boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }

        return true;
    }
}

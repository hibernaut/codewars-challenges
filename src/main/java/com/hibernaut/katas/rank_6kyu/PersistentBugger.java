package com.hibernaut.katas.rank_6kyu;

import java.util.stream.Stream;

/**
 * Write a function, persistence, that takes in a positive parameter num and returns
 * its multiplicative persistence, which is the number of times you must multiply the digits
 * in num until you reach a single digit.
 *
 * For example (Input --> Output):
 *
 * 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
 * 999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
 * 4 --> 0 (because 4 is already a one-digit number)
 */

public class PersistentBugger {
    public static int persistence(long n) {
        int persistence = 0;

        while(String.valueOf(n).length() > 1){

            n = Stream.of(String.valueOf(n).split(""))
                    .mapToInt(Integer::valueOf)
                    .reduce(1, (a, b) -> a * b);

            persistence += 1;
        }

        return persistence;
    }
}

package com.hibernaut.katas;

/**
 * Complete the solution so that it returns true if the first argument(string)
 * passed in ends with the 2nd argument (also a string).
 * <p>
 * Examples:
 * <p>
 * solution('abc', 'bc') // returns true
 * solution('abc', 'd') // returns false
 */

public class StringEndsWith {
    public static boolean isEnding(String str, String ending) {
        return str.endsWith(ending);
    }

}
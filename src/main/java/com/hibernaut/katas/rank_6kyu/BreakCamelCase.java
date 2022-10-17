package com.hibernaut.katas.rank_6kyu;

/**
 * Complete the solution so that the function will break up camel casing, using a space between words.
 * Example
 *
 * "camelCasing"  =>  "camel Casing"
 * "identifier"   =>  "identifier"
 * ""             =>  ""
 */

public class BreakCamelCase {
    public static String camelCase(String input) {
        StringBuilder builder = new StringBuilder();

        for (Character c : input.toCharArray()) {
            if(Character.isUpperCase(c)) {
                builder.append(" ");
            }

            builder.append(c);
        }

        return builder.toString();
    }
}

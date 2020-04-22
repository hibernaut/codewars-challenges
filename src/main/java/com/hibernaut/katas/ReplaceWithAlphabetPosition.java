package com.hibernaut.katas;

/**
 * Welcome. In this kata you are required to, given a string, replace every letter with its position in the alphabet.
 * If anything in the text isn't a letter, ignore it and don't return it.
 * "a" = 1, "b" = 2, etc.
 * Example alphabet_position("The sunset sets at twelve o' clock.")
 * Should return "20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11" (as a string)
 */

public class ReplaceWithAlphabetPosition {
    static String stringToNumbers(String inputString) {

        String inString = new String(inputString.toLowerCase());
        StringBuffer outString = new StringBuffer("");

        char[] keyLetterArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String[] keyNumberArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};

        for (int i = 0; i < inString.length(); i++) {
            for (int j = 0; j < keyLetterArray.length; j++) {
                if (inString.charAt(i) == keyLetterArray[j]) {
                    outString.append(keyNumberArray[j] + " ");
                }
            }
        }

        return new String(outString).trim();
    }
}

package com.hibernaut.katas.rank_6kyu;

/**
 * #Find the missing letter
 * Write a method that takes an array of consecutive (increasing)
 * letters as input and that returns the missing letter in the array.
 * You will always get an valid array. And it will be always exactly one letter be missing.
 * The length of the array will always be at least 2.
 * The array will always contain letters in only one case.
 * Example:
 * ['a','b','c','d','f'] -> 'e' 
 * ['O','Q','R','S'] -> 'P'
 * ["a","b","c","d","f"] -> "e"
 * ["O","Q","R","S"] -> "P"
 * (Use the English alphabet with 26 letters!)
 */

public class FindMissingLetter {
    public static char findMissingLetter(char[] array) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        if (Character.isUpperCase(array[0])) {
            alphabet = alphabet.toUpperCase();
        }

        char missingLetter = ' ';

        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == array[0]) {
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != alphabet.charAt(i + j)) {
                        missingLetter = alphabet.charAt(i + j);
                        break;
                    }
                }
            }
        }
        
        return missingLetter;
    }
}

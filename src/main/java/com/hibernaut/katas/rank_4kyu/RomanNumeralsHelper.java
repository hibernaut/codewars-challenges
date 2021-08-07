package com.hibernaut.katas.rank_4kyu;

/**
 * Create a RomanNumerals class that can convert a roman numeral to and from an integer value.
 * It should follow the API demonstrated in the examples below.
 * Multiple roman numeral values will be tested for each helper method.
 * <p>
 * Modern Roman numerals are written by expressing each digit separately starting
 * with the left most digit and skipping any digit with a value of zero.
 * In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC.
 * 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
 * Examples
 * <p>
 * RomanNumerals.toRoman(1000) // should return 'M'
 * RomanNumerals.fromRoman("M") // should return 1000
 * <p>
 * Help
 * Symbol 	Value
 * I 	1
 * V 	5
 * X 	10
 * L 	50
 * C 	100
 * D 	500
 * M 	1000
 */

public class RomanNumeralsHelper {
    public static String toRoman(int n) {
        int ones = n % 10;
        int tens = (n / 10) % 10;
        int hundreds = (n / 100) % 10;
        int thousands = n / 1000;

        StringBuilder builder = new StringBuilder();

        if (thousands != 0) {
            for (int i = 0; i < thousands; i++) {
                builder.append('M');
            }
        }

        counter(builder, hundreds, 'M', 'D', 'C');
        counter(builder, tens, 'C', 'L', 'X');
        counter(builder, ones, 'X', 'V', 'I');

        return builder.toString();
    }

    public static int fromRoman(String romanNumeral) {
        String[] romanLiterals = romanNumeral.split("");
        int number = 0;

        for (int i = 0; i < romanLiterals.length; i++) {
            switch (romanLiterals[i]) {
                case "M":
                    romanLiterals[i] = "1000";
                    break;
                case "D":
                    romanLiterals[i] = "500";
                    break;
                case "C":
                    romanLiterals[i] = "100";
                    break;
                case "L":
                    romanLiterals[i] = "50";
                    break;
                case "X":
                    romanLiterals[i] = "10";
                    break;
                case "V":
                    romanLiterals[i] = "5";
                    break;
                default:
                    romanLiterals[i] = "1";
                    break;
            }
        }

        for (int i = 0; i < romanLiterals.length - 1; i++) {
            int current = Integer.parseInt(romanLiterals[i]);
            int next = Integer.parseInt(romanLiterals[i + 1]);

            if (current < next) {
                number -= current;
            } else {
                number += current;
            }
        }

        number += Integer.parseInt(romanLiterals[romanLiterals.length - 1]);

        return number;
    }

    private static void counter(StringBuilder builder, int numericalPlaceCount, char ten, char five, char one) {
        if (numericalPlaceCount == 4) {
            builder.append(one).append(five);
        } else if (numericalPlaceCount == 5) {
            builder.append(five);
        } else if (numericalPlaceCount == 9) {
            builder.append(one).append(ten);
        } else if (numericalPlaceCount < 5) {
            for (int i = 0; i < numericalPlaceCount; i++) {
                builder.append(one);
            }
        } else {
            builder.append(five);
            for (int i = 0; i < (numericalPlaceCount - 5); i++) {
                builder.append(one);
            }
        }
    }
}

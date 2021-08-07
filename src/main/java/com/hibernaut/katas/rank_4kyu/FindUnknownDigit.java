package com.hibernaut.katas.rank_4kyu;

import java.util.regex.Pattern;

/**
 * "Find the unknown digit" (4kyu)
 * To give credit where credit is due: This problem was taken from the ACMICPC-Northwest Regional Programming Contest.
 * Thank you problem writers.
 * You are helping an archaeologist decipher some runes. He knows that this ancient society used a Base 10 system,
 * and that they never start a number with a leading zero. He's figured out most of the digits as well as a few operators,
 * but he needs your help to figure out the rest.
 * The professor will give you a simple math expression, of the form
 * <p>
 * [number][op][number]=[number]
 * <p>
 * He has converted all of the runes he knows into digits. The only operators he knows are addition (+),
 * subtraction(-), and multiplication (*), so those are the only ones that will appear.
 * Each number will be in the range from -1000000 to 1000000, and will consist of only the digits 0-9,
 * possibly a leading -, and maybe a few ?s. If there are ?s in an expression,
 * they represent a digit rune that the professor doesn't know
 * (never an operator, and never a leading -). All of the ?s in an expression will represent the same digit (0-9),
 * and it won't be one of the other given digits in the expression.
 * No number will begin with a 0 unless the number itself is 0, therefore 00 would not be a valid number.
 * Given an expression, figure out the value of the rune represented by the question mark.
 * If more than one digit works, give the lowest one.
 * If no digit works, well, that's bad news for the professor - it means
 * that he's got some of his runes wrong. output -1 in that case.
 * Complete the method to solve the expression to find the value of the unknown rune.
 * The method takes a string as a paramater repressenting the expression
 * and will return an int value representing the unknown rune or -1 if no such rune exists.
 **/

public class FindUnknownDigit {
    public static int solveExpression(final String expression) {
        String[] values;
        String[] operands;
        char replacingCharacter;
        String operand1;
        String operand2;
        String possibleResult;
        String operator;
        int result = 0;

        // Create temporary array with operands and result
        values = expression.split("=");

        // Split string with operands by operator and store operator's value
        if (values[0].contains("--")) {
            operator = "-";
            operands = values[0].split("--");
            operands[1] = "-" + operands[1];
        } else if (values[0].contains("*")) {
            operator = "*";
            operands = values[0].split("\\*");
        } else if (values[0].contains("+")) {
            operator = "+";
            operands = values[0].split("\\+");
        } else {
            operator = "-";
            if (values[0].startsWith("-")) {
                operands = values[0].substring(1).split("-");
            } else {
                operands = values[0].split("-");
            }
        }

        // Find what digit fits to the expression
        for (int i = 0; i < 10; i++) {
            replacingCharacter = Character.forDigit(i, 10);
            if (!expression.contains(String.valueOf(replacingCharacter))) {
                operand1 = operands[0].replace('?', replacingCharacter);
                operand2 = operands[1].replace('?', replacingCharacter);
                possibleResult = values[1].replace('?', replacingCharacter);

                if ((Pattern.matches("-?[^0-]\\w*", operand1) || Pattern.matches("-?\\w", operand1))
                        && (Pattern.matches("-?[^0-]\\w*", operand2) || Pattern.matches("-?\\w", operand2))
                        && (Pattern.matches("-?[^0-]\\w*", possibleResult) || Pattern.matches("-?\\w", possibleResult))) {
                    switch (operator) {
                        case "*":
                            result = Integer.parseInt(operand1) * Integer.parseInt(operand2);
                            break;
                        case "+":
                            result = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                            break;
                        case "-":
                            result = Integer.parseInt(operand1) - Integer.parseInt(operand2);
                            break;
                    }

                    if (result == Integer.parseInt(values[1].replace('?', Character.forDigit(i, 10)))) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}

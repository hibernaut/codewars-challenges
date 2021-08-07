package com.hibernaut.katas.rank_4kyu;

/**
 * Write a function that determines whether a string is a valid guess in a Boggle board,
 * as per the rules of Boggle.
 * A Boggle board is a 2D array of individual characters, e.g.:
 * <p>
 * [ ['I','L','A','W'],
 * ['B','N','G','E'],
 * ['I','U','A','O'],
 * ['A','S','R','L'] ]
 * <p>
 * Valid guesses are strings which can be formed by connecting adjacent cells
 * (horizontally, vertically, or diagonally) without re-using any previously used cells.
 * <p>
 * For example, in the above board "BINGO", "LINGO",
 * and "ILNBIA" would all be valid guesses, while "BUNGIE", "BINS", and "SINUS" would not.
 * <p>
 * Your function should take two arguments (a 2D array and a string)
 * and return true or false depending on whether the string
 * is found in the array as per Boggle rules.
 * <p>
 * Test cases will provide various array and string sizes
 * (squared arrays up to 150x150 and strings up to 150 uppercase letters).
 * You do not have to check whether the string is a real word or not,
 * only if it's a valid guess.
 */

public class BoggleWordChecker {
    private char[][] board;
    final String word;

    public BoggleWordChecker(final char[][] board, final String word) {
        this.board = board;
        this.word = word;
    }

    // Main method which check either a word matches or not
    public boolean check() {
        if (word == null || word.isEmpty()) {
            return false;
        }

        int[][] usedLetters = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && doMatch(i, j, 1, usedLetters)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Recursive method determines letter eligibility
    public boolean doMatch(int previousLetterRow, int previousLetterColumn, int letterIndex, int[][] usedLetters) {
        if (letterIndex >= word.length()) {
            return true;
        }

        char letter = word.charAt(letterIndex);
        usedLetters[previousLetterRow][previousLetterColumn] = 1;

        for (int i = previousLetterRow - 1; i <= previousLetterRow + 1; i++) {
            for (int j = previousLetterColumn - 1; j <= previousLetterColumn + 1; j++) {
                if (i >= 0 && j >= 0 && i < board.length && j < board[i].length) {
                    if (board[i][j] == letter && usedLetters[i][j] != 1 && doMatch(i, j, letterIndex + 1, usedLetters)) {
                        return true;
                    }
                }
            }
        }

        usedLetters[previousLetterRow][previousLetterColumn] = 0;

        return false;
    }
}

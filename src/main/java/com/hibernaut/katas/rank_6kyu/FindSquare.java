package com.hibernaut.katas.rank_6kyu;

/**
 * A rectangle can be split up into a grid of 1x1 squares,
 * the amount of which being equal to the product of the two dimensions of the rectangle.
 * Depending on the size of the rectangle, that grid of 1x1 squares can also be split up into larger squares,
 * for example a 3x2 rectangle has a total of 8 squares, as there are 6 distinct 1x1 squares,
 * and two possible 2x2 squares. A 4x3 rectangle contains 20 squares.
 *
 * Your task is to write a function `findSquares` that returns the total number of squares
 * for any given rectangle, the dimensions of which being given as two integers with the first
 * always being equal to or greater than the second.
 */

public class FindSquare {
    public static int findSquares(int x, int y){
        int squares = x * y;
        int maxSquareSize = x;
        int a, b;

        if(x > y) {
            maxSquareSize = y;
        }

        for(int i = 2; i <= maxSquareSize; i++) {
            a = x - i + 1;
            b = y - i + 1;

            squares += a * b;
        }
        return squares;
    }
}

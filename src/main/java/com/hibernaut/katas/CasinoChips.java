package com.hibernaut.katas;

import java.util.Arrays;

/**
 * You are given three piles of casino chips: white, green and black chips:
 * <p>
 * the first pile contains only white chips
 * the second pile contains only green chips
 * the third pile contains only black chips
 * <p>
 * Each day you take exactly two chips of different colors and head to the casino.
 * You can choose any color, but you are not allowed to take two chips of the same color in a day.
 * <p>
 * You will be given an array representing the number of chips of each color and your task is to return the maximum number of days you can pick the chips.
 * Each day you need to take exactly two chips.
 * <p>
 * solve([1,1,1]) = 1, because after you pick on day one, there will be only one chip left
 * solve([1,2,1]) = 2, you can pick twice; you pick two chips on day one then on day two
 * solve([4,1,1]) = 2
 * solve([5,1,3]) = 4
 * <p>
 * More examples in the test cases. Good luck!
 * <p>
 * Brute force is not the way to go here. Look for a simplifying mathematical approach.
 */

public class CasinoChips {
    public static int solve(int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // If sum of chips from the other piles
        // bigger than number of chips from the biggest pile,
        // maximum number of days:
        // chips from the biggest pile + (sum of chips from the other piles - chips from the biggest pile) / 2
        if ((arr[0] + arr[1]) > arr[2]) {
            return arr[2] + (arr[0] + arr[1] - arr[2]) / 2;
        }

        //Else maximum number of days: sum of chips from the other piles
        else {
            return arr[0] + arr[1];
        }
    }
}

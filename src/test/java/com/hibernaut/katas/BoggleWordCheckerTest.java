package com.hibernaut.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

/**
 * Created by hibernaut on 16.05.2021.
 */
public class BoggleWordCheckerTest {
    final private static char[][] board = {
            {'E', 'A', 'R', 'A'},
            {'N', 'L', 'E', 'C'},
            {'I', 'A', 'I', 'S'},
            {'B', 'Y', 'O', 'R'}
    };

    private static String[] toCheck = {"C", "EAR", "EARS", "BAILER", "RSCAREIOYBAILNEA", "CEREAL", "ROBES", "ALEC"};
    private static boolean[] expecteds = {true, true, false, true, true, false, false, true};

    @Test
    public void sampleTests() {
        for (int i = 0; i < toCheck.length; i++) {
            assertEquals(expecteds[i], new BoggleWordChecker(deepCopy(board), toCheck[i]).check());
        }
    }

    private char[][] deepCopy(char[][] arr) {
        return Arrays.stream(arr)
                .map(a -> Arrays.copyOf(a, a.length))
                .toArray(char[][]::new);
    }
}

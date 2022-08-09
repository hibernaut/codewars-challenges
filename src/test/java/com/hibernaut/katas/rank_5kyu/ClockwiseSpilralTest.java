package com.hibernaut.katas.rank_5kyu;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ClockwiseSpilralTest {
    @Test
    public void should_test_spiral() {
        assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, ClockwiseSpiral.createSpiral(3));
        assertArrayEquals(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}, ClockwiseSpiral.createSpiral(4));
        assertArrayEquals(new int[][]{{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}}, ClockwiseSpiral.createSpiral(5));
    }
}

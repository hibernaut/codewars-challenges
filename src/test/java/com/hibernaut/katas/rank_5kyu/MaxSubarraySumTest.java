package com.hibernaut.katas.rank_5kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSubarraySumTest {
    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, MaxSubarraySum.sequence(new int[]{}));
    }
    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, MaxSubarraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

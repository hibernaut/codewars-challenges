package com.hibernaut.katas.rank_4kyu;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CountOnesInSegmentTest {
    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("7"), CountOnesInSegment.countOnes(5,7));
        assertEquals(new BigInteger("51"), CountOnesInSegment.countOnes(12,29));
    }
}

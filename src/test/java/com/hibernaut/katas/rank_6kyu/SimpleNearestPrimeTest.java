package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SimpleNearestPrimeTest {
    @Test
    public void basicTests() {
        assertEquals(3L, SimpleNearestPrime.solve(3L));
        assertEquals(11L, SimpleNearestPrime.solve(11L));
        assertEquals(3L, SimpleNearestPrime.solve(4L));
        assertEquals(109L, SimpleNearestPrime.solve(110L));
        assertEquals(1109L, SimpleNearestPrime.solve(1110L));
        assertEquals(2999L, SimpleNearestPrime.solve(3000L));
        assertEquals(34981L, SimpleNearestPrime.solve(35000L));
        assertEquals(10000000019L, SimpleNearestPrime.solve(10000000000L));
    }
}

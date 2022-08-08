package com.hibernaut.katas.rank_5kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeMultiplesTest {
    @Test
    public void testSmall() {
        assertEquals("23", PrimeMultiples.findThem("10", new int[]{3,5}));
        assertEquals("37", PrimeMultiples.findThem("10", new int[]{2,3,5}));
        assertEquals("36326", PrimeMultiples.findThem("300", new int[]{2,3,5,7,11,13}));
        assertEquals("104", PrimeMultiples.findThem("18", new int[]{2,3,5}));
        assertEquals("333", PrimeMultiples.findThem("29", new int[]{2,3,5,7,11}));
    }

    @Test
    public void testMedium() {
        assertEquals("4209783663", PrimeMultiples.findThem("100000", new int[]{2,3,5,7,11,13,17,19,23,29}));
    }

    @Test
    public void testBig() {
        assertEquals("4256395812485266", PrimeMultiples.findThem("100000001", new int[]{2,3,5,7,11,13,17,19,23,29,31,37}));
    }
}

package com.hibernaut.katas.rank_4kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecomposeSquareTest {
    @Test
    public void test1() {
        assertEquals("1 2 4 10",  DecomposeSquare.decompose(11));
        assertEquals("1 3 5 8 49",  DecomposeSquare.decompose(50));
        assertEquals("2 3 6",  DecomposeSquare.decompose(7));
    }
}

package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReplaceWithAlphabetPositionTest {
    @Test
    public void test() {
        assertEquals("20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11",
                ReplaceWithAlphabetPosition.stringToNumbers("The sunset sets at twelve o' clock."));
        assertEquals("20 8 5 14 1 18 23 8 1 12 2 1 3 15 14 19 1 20 13 9 4 14 9 7 8 20",
                ReplaceWithAlphabetPosition.stringToNumbers("The narwhal bacons at midnight."));
        assertEquals("1 4 4 5 5 5 12 16 23 5 20 25 21 12 12 15 11 11",
                ReplaceWithAlphabetPosition.stringToNumbers("a//ddEEElp.,{}{weTYULL][oKK"));

    }
}

package com.hibernaut.katas.rank_7kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringEndsWithTest {
    @Test
    public void testIsEnding() {
        assertEquals(true, StringEndsWith.isEnding("abc", "bc"));
        assertEquals(true, StringEndsWith.isEnding("Hello world!!!", "d!!!"));
        assertEquals(false, StringEndsWith.isEnding("abcdef", "bcd"));
        assertEquals(true, StringEndsWith.isEnding("", ""));
        assertEquals(true, StringEndsWith.isEnding(" ", " "));
    }
}

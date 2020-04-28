package com.hibernaut.katas;

import static org.junit.Assert.*;
import org.junit.Test;

// TODO: Replace examples and use TDD development by writing your own tests

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
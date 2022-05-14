package com.hibernaut.katas.rank_4kyu;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NextSmallerNumberTest {
    @Test
    public void basicTests() {
        assertEquals(12, NextSmallerNumber.nextSmaller(21));
        assertEquals(790, NextSmallerNumber.nextSmaller(907));
        assertEquals(513, NextSmallerNumber.nextSmaller(531));
        assertEquals(-1, NextSmallerNumber.nextSmaller(1027));
        assertEquals(414, NextSmallerNumber.nextSmaller(441));
        assertEquals(123456789, NextSmallerNumber.nextSmaller(123456798));
        assertEquals(1072, NextSmallerNumber.nextSmaller(1207));
    }
}

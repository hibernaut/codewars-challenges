package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ColorChoiceTest {
    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(2, ColorChoice.checkchoose(6, 4));
        assertEquals(1, ColorChoice.checkchoose(4, 4));
        assertEquals(3, ColorChoice.checkchoose(35, 7));
        assertEquals(-1, ColorChoice.checkchoose(4, 2));
        assertEquals(-1, ColorChoice.checkchoose(36, 7));
        assertEquals(20, ColorChoice.checkchoose(47129212243960L, 50));
        assertEquals(11, ColorChoice.checkchoose(129024480, 32));
    }
}

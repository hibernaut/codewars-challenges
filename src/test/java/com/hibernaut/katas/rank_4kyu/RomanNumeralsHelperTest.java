package com.hibernaut.katas.rank_4kyu;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RomanNumeralsHelperTest {
    @Test
    public void testToRoman() {
        assertThat("1 converts to 'I'", RomanNumeralsHelper.toRoman(1), is("I"));
        assertThat("2 converts to 'II'", RomanNumeralsHelper.toRoman(2), is("II"));
    }

    @Test
    public void testFromRoman() {
        assertThat("'I' converts to 1", RomanNumeralsHelper.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumeralsHelper.fromRoman("II"), is(2));
    }
}
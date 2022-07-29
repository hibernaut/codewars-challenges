package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FindMissingLetterTest {
    @Test
    public void exampleTests() {
        assertEquals('e', FindMissingLetter.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', FindMissingLetter.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
        assertEquals('W', FindMissingLetter.findMissingLetter(new char[]{'T', 'U', 'V', 'X', 'Y', 'Z'}));
    }
}

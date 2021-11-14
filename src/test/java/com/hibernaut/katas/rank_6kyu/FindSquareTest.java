package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FindSquareTest {
    @Test
    public void test1(){
        assertEquals(8, FindSquare.findSquares(3,2));
    }
    @Test
    public void test2(){
        assertEquals(20, FindSquare.findSquares(4,3));
    }
    @Test
    public void test3(){
        assertEquals(100, FindSquare.findSquares(11,4));
    }
}
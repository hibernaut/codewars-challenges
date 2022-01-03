package com.hibernaut.katas.rank_4kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumByFactorsTest {
    @Test
    public void testOne() {
        int[] lst1 = new int[]{12, 15};
        int[] lst2 = new int[]{15, 30, -45};
        int[] lst3 = new int[]{-11, 145, 243, 137, 328, 359, 405, 8, 421, 308};
        int[] lst4 = new int[]{-29804, -4209, -28265, -72769, -31744};
        assertEquals("(2 12)(3 27)(5 15)", SumByFactors.sumOfDivided(lst1));
        assertEquals("(2 30)(3 0)(5 0)", SumByFactors.sumOfDivided(lst2));
        assertEquals("(2 644)(3 648)(5 550)(7 308)(11 297)(29 145)(41 328)(137 137)(359 359)(421 421)", SumByFactors.sumOfDivided(lst3));
        assertEquals("(2 -61548)(3 -4209)(5 -28265)(23 -4209)(31 -31744)(53 -72769)(61 -4209)(1373 -72769)(5653 -28265)(7451 -29804)", SumByFactors.sumOfDivided(lst4));
    }
}
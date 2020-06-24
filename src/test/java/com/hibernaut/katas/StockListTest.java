package com.hibernaut.katas;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockListTest {

    @Test
    public void test1() {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[]{"A", "B"};
        assertEquals("(A : 200) - (B : 1140)",
                StockList.stockSummary(art, cd));
    }

    @Test
    public void test2() {
        String art[] = new String[]{"AGFR 100", "COLP 425", "BLPI 250", "BYEW 890"};
        String cd[] = new String[]{};
        assertEquals("",
                StockList.stockSummary(art, cd));
    }

    @Test
    public void test3() {
        String art[] = new String[]{};
        String cd[] = new String[]{"A", "B", "C"};
        assertEquals("",
                StockList.stockSummary(art, cd));
    }

    @Test
    public void test4() {
        String art[] = new String[]{};
        String cd[] = new String[]{};
        assertEquals("",
                StockList.stockSummary(art, cd));
    }
}

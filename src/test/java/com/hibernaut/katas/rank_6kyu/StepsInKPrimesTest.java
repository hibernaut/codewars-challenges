package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepsInKPrimesTest {
    private static String listArrayLongToString(List<long[]> res) {
        String s = "["; int l = res.size();
        for (int i = 0; i < l; i++) {
            long[] a = res.get(i);
            s += "[" + a[0] + ", " + a[1];
            if (i < l-1) s += "], ";
            else s += "]";
        }
        return s += "]";
    }
    private static void testing(int k, int step, long start, long nd, String expected) {
        List<long[]> a = StepsInKPrimes.kprimesStep(k, step, start, nd);
        String actual = listArrayLongToString(a);
        System.out.println("k " + k + " step " + step + " start " + start + " end " + nd);
        //System.out.println("got --> " + actual);
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("Basic Tests");
        testing(10, 8, 2425364, 2425700, "[]");
        testing(6, 8, 2627371, 2627581, "[[2627408, 2627416], [2627440, 2627448], [2627496, 2627504]]");
        testing(2, 2, 0, 50, "[[4, 6], [33, 35]]");
        testing(6, 14, 2113665, 2113889, "[[2113722, 2113736]]");
        testing(2, 10, 0, 50, "[[4, 14], [15, 25], [25, 35], [39, 49]]");
        testing(5, 20, 0, 50, "[]");
    }
}
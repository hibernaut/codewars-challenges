package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import static org.junit.Assert.*;

public class BonusesTest {
    private static boolean verif(long[] ls, long s) {
        long t = 0;
        for (int i = 0; i < ls.length; i++)
            t += ls[i];
        return t == s;
    }

    private static void dotest(int[] arr, long s, long[] expect) {
        long[] actual = Bonuses.bonus(arr, s);
        boolean v = verif(actual, s);
        if (!v) {
            long t = 0;
            for (int i = 0; i < actual.length; i++)
                t += actual[i];
            System.out.println("The sum of your result is not 's': you got " + t + " instead of " + s);
            assertEquals("The sum of your resulting array is not 'total bonus'", v, true);
        } else {
            assertArrayEquals(expect, actual);
        }
    }

    @Test
    public void test1() {
        dotest(new int[]{22, 3, 15}, 18228, new long[]{1860, 13640, 2728});
        dotest(new int[]{8, 14, 11}, 23541, new long[]{10241, 5852, 7448});
        dotest(new int[]{8, 20, 17}, 25281, new long[]{13515, 5406, 6360});
        dotest(new int[]{6, 15, 23}, 22156, new long[]{13340, 5336, 3480});
        dotest(new int[]{7, 9, 12}, 10880, new long[]{4608, 3584, 2688});
    }
}
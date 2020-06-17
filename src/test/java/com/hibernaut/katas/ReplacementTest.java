package com.hibernaut.katas;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class ReplacementTest {
    private static void doTest(int[] actual, int[] expected) {assertArrayEquals(Replacement.replacement(actual), expected);}

    @Test
    public void basicTests() {
        ReplacementTest.doTest(new int[]{1,2,3,4,5}, new int[]{1,1,2,3,4});
        ReplacementTest.doTest(new int[]{4,2,1,3,5}, new int[]{1,1,2,3,4});
        ReplacementTest.doTest(new int[]{2,3,4,5,6}, new int[]{1,2,3,4,5});
        ReplacementTest.doTest(new int[]{2,2,2}, new int[]{1,2,2});
        ReplacementTest.doTest(new int[]{42}, new int[]{1});
    }
    @Test
    public void edgeTests() {
        ReplacementTest.doTest(new int[]{5,6,1,2,3,1,3,45,7,1000000000}, new int[]{1,1,1,2,3,3,5,6,7,45});
        ReplacementTest.doTest(new int[]{1,1,1}, new int[]{1,1,2});
        ReplacementTest.doTest(new int[]{1}, new int[]{2});
        ReplacementTest.doTest(new int[]{2,2,2}, new int[]{1,2,2});
    }
    @Test
    public void randomTests() {
        Random rand = new Random();
        for (int trial = 1; trial <= 100; trial++) {
            int arr[]      = new int[rand.nextInt(99) + 1],
                    expected[] = new int[arr.length],
                    max        = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = expected[i] = rand.nextInt(999) + 1;
                if ( arr[i] > arr[max] )
                    max = i;
            }
            expected[max] = 1 == expected[max] ? 2 : 1;
            Arrays.sort(expected);
            ReplacementTest.doTest(arr, expected);
        }
    }
}

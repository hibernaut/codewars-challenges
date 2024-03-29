package com.hibernaut.katas.rank_4kyu;

import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;


public class MagneticParticulesInBoxesTest {
    private static void assertFuzzyEquals(double act, double exp) {
        boolean inrange = Math.abs(act - exp) <= 1e-6;
        if (inrange == false) {
            DecimalFormat df = new DecimalFormat("#0.000000");
            System.out.println("At 1e-6: Expected must be " + df.format(exp) + ", but got " + df.format(act));
        }
        assertEquals(true, inrange);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: doubles");
        assertFuzzyEquals(MagneticParticulesInBoxes.doubles(1, 10), 0.5580321939764581);
        assertFuzzyEquals(MagneticParticulesInBoxes.doubles(10, 1000), 0.6921486500921933);
        assertFuzzyEquals(MagneticParticulesInBoxes.doubles(10, 10000), 0.6930471674194457);
        assertFuzzyEquals(MagneticParticulesInBoxes.doubles(20, 10000), 0.6930471955575918);
    }
}

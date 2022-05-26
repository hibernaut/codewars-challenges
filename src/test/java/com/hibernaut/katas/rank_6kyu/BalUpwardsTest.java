package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalUpwardsTest {
    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("Fixed Tests maxBall");
        testing(BallUpwards.maxBall(37), 10);
        testing(BallUpwards.maxBall(45), 13);
        testing(BallUpwards.maxBall(99), 28);
        testing(BallUpwards.maxBall(85), 24);
    }
}

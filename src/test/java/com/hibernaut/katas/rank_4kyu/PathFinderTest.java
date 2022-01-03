package com.hibernaut.katas.rank_4kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathFinderTest {
    @Test
    public void sampleTests() {

        String a = ".W.\n" +
                ".W.\n" +
                "...",

                b = ".W.\n" +
                        ".W.\n" +
                        "W..",

                c = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......",

                d = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        ".....W\n" +
                        "....W.";

        assertEquals(a, 4, PathFinder.pathFinder(a));
        assertEquals(b, -1, PathFinder.pathFinder(b));
        assertEquals(c, 10, PathFinder.pathFinder(c));
        assertEquals(d, -1, PathFinder.pathFinder(d));
    }
}
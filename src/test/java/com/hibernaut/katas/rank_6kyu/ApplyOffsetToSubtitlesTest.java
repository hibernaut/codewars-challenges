package com.hibernaut.katas.rank_6kyu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ApplyOffsetToSubtitlesTest {
    private static void doTest(String actual, String expected, int offset) {
        assertEquals(expected, ApplyOffsetToSubtitles.subsOffsetApply(actual, offset));
    }

    @Test
    public void basicTests() {
        ApplyOffsetToSubtitlesTest.doTest("01:09:02,684 --> 01:09:03,601 Run Forrest, run!",
                "02:10:06,339 --> 02:10:07,256 Run Forrest, run!", 3663655);
        ApplyOffsetToSubtitlesTest.doTest("00:43:22,074 --> 00:43:24,159 No, I am your father.",
                "00:43:23,863 --> 00:43:25,948 No, I am your father.", 1789);
        ApplyOffsetToSubtitlesTest.doTest("00:03:06,241 --> 00:03:07,618 I`ll be back.",
                "00:02:44,452 --> 00:02:45,829 I`ll be back.", -21789);
        ApplyOffsetToSubtitlesTest.doTest("00:03:14,917 --> 00:03:16,001 My name is Bond. James Bond.",
                "Invalid offset", -195000);
    }

    @Test
    public void borderLineTests() {
        ApplyOffsetToSubtitlesTest.doTest("01:00:00,000 --> 01:00:02,000 Let`s start with this.",
                "00:00:00,000 --> 00:00:02,000 Let`s start with this.", -3600000);
        ApplyOffsetToSubtitlesTest.doTest("01:00:00,000 --> 01:00:02,000 Let`s finish this.",
                "99:59:57,999 --> 99:59:59,999 Let`s finish this.", 356397999);
    }
}

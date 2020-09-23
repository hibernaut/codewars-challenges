package com.hibernaut.katas;

import java.util.Arrays;

import static java.lang.Math.*;

/**
 * You are given a line from a movie subtitle file as a string.
 * The line consists of time interval when the text is shown:
 * <p>
 * start(hh:mm:ss,ms) --> stop(hh:mm:ss,ms)
 * <p>
 * and the text itself, for example:
 * <p>
 * 01:09:02,684 --> 01:09:03,601 Run Forrest, run!
 * <p>
 * Your task is to write a function subs_offset_apply which takes such string and offset
 * (integer) in miliseconds as arguments, and returns the string with the offset applied.
 * Examples:
 * <p>
 * string = "01:09:02,684 --> 01:09:03,601 Run Forrest, run!"
 * subs_offset_apply(string, 3663655)
 * output: "02:10:06,339 --> 02:10:07,256 Run Forrest, run!"
 * <p>
 * "00:43:22,074 --> 00:43:24,159 No, I am your father."
 * subs_offset_apply(string, 1789)
 * output: "00:43:23,863 --> 00:43:25,948 No, I am your father."
 * <p>
 * "00:03:06,241 --> 00:03:07,618 I'll be back."
 * subs_offset_apply(string, -21789)
 * output: "00:02:44,452 --> 00:02:45,829 I'll be back."
 * <p>
 * Time constraints:
 * <p>
 * 00:00:00,000 <= t <= 99:59:59,999
 * <p>
 * In case of too big negative or positive offset, which results in exceeding the constraints,
 * the function should return a string "Invalid offset".
 * You'll be given only valid strings.
 * Have Fun!
 */

public class ApplyOffsetToSubtitles {
    public static String subsOffsetApply(String subtitle, int offset) {
        int offsetLimit = 359999999;
        int commonStartTime;
        int commonStopTime;
        int timeFormat;
        String[] splittedArray;
        String[] startTime;
        String[] stopTime;
        String result;

        splittedArray = subtitle.split("[\\s]");
        startTime = splittedArray[0].split("[:\\,]");
        stopTime = splittedArray[2].split("[:\\,]");


        commonStartTime = (((Integer.parseInt(startTime[0]) * 60 +
                Integer.parseInt(startTime[1])) * 60 +
                Integer.parseInt(startTime[2])) * 1000 +
                Integer.parseInt(startTime[3])) + offset;

        commonStopTime = (((Integer.parseInt(stopTime[0]) * 60 +
                Integer.parseInt(stopTime[1])) * 60 +
                Integer.parseInt(stopTime[2])) * 1000 +
                Integer.parseInt(stopTime[3])) + offset;

        if (commonStartTime < 0 || commonStopTime > offsetLimit) {
            return "Invalid offset";
        }

        for (int i = startTime.length - 1; i >= 1; i--) {
            int s = 1000;
            if (i != startTime.length - 1) {
                s = 60;
            }

            timeFormat = commonStartTime % s;

            if (i == startTime.length - 1) {
                startTime[i] = String.format("%03d", timeFormat);
            } else {
                startTime[i] = String.format("%02d", timeFormat);
            }

            commonStartTime /= s;

            timeFormat = commonStopTime % s;

            if (i == startTime.length - 1) {
                stopTime[i] = String.format("%03d", timeFormat);
            } else {
                stopTime[i] = String.format("%02d", timeFormat);
            }

            commonStopTime /= s;

        }

        startTime[0] = String.format("%02d", commonStartTime);
        stopTime[0] = String.format("%02d", commonStopTime);

        result = startTime[0] + ":" + startTime[1] + ":" + startTime[2] + "," + startTime[3] + " --> " +
                stopTime[0] + ":" + stopTime[1] + ":" + stopTime[2] + "," + stopTime[3] + " ";

        for (int i = 3; i < splittedArray.length; i++) {
            if (i < splittedArray.length - 1) {
                result += splittedArray[i] + " ";
            } else {
                result += splittedArray[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsOffsetApply("01:00:00,000 --> 01:00:02,000 Let`s finish this.", 356397999));
    }
}

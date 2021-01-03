package com.hibernaut.katas;


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
        String[] splittedArray;
        String[] startTime;
        String[] stopTime;

        // Split array into start time and stop time
        splittedArray = subtitle.split("\\s");
        startTime = splittedArray[0].split("[:,]");
        stopTime = splittedArray[2].split("[:,]");

        // Calculate common time with offset in milliseconds
        commonStartTime = calcCommonTime(startTime, offset);
        commonStopTime = calcCommonTime(stopTime, offset);

        // Check if the values are correct
        if (commonStartTime < 0 || commonStopTime > offsetLimit) {
            return "Invalid offset";
        }

        // Convert time into required format
        splittedArray[0] = convertMilliseconds(commonStartTime);
        splittedArray[2] = convertMilliseconds(commonStopTime);


        return String.join(" ", splittedArray);
    }

    // Function which calculates common time with offset in milliseconds
    public static int calcCommonTime(String[] array, int offset) {
        return (((Integer.parseInt(array[0]) * 60 +
                Integer.parseInt(array[1])) * 60 +
                Integer.parseInt(array[2])) * 1000 +
                Integer.parseInt(array[3])) + offset;
    }

    // Function which convert time in milliseconds into format "hh:mm:ss:msmsms"
    public static String convertMilliseconds(int time) {
        int h = time / 3600000;
        int m = (time - h * 3600000) / 60000;
        int s = (time - (h * 3600000 + m * 60000)) / 1000;
        int ms = time - (h * 3600000 + m * 60000 + s * 1000);

        return String.format("%02d:%02d:%02d,%03d", h, m, s, ms);
    }
}

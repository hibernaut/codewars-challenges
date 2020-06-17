package com.hibernaut.katas;

import java.util.Arrays;

public class Replacement {
    public static int[] replacement(final int[] arr) {
        int lastIndex = arr.length - 1;

        Arrays.sort(arr);

        if (arr[lastIndex] == 1) {
            arr[lastIndex] = 2;
        } else {
            arr[lastIndex] = 1;
            Arrays.sort(arr);
        }

        return arr;
    }
}

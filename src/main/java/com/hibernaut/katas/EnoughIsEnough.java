package com.hibernaut.katas;

import java.util.ArrayList;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        int itemOccurrences;
        ArrayList<Integer> list = new ArrayList<> ();

        for(int element : elements) {
            itemOccurrences = (int) list.stream()
                    .filter(i -> i == element)
                    .count();
            if(itemOccurrences < maxOccurrences) {
                list.add(element);
            }
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}

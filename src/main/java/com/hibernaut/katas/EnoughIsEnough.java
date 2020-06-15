package com.hibernaut.katas;

import java.util.ArrayList;
import java.util.stream.*;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurences) {
        int itemOccurences = 0;

        ArrayList<Integer> list = IntStream.of(elements)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> unique = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            if (!unique.contains(list.get(i))) {
                unique.add(list.get(i));
            }
        }

        for (int i = 0; i < unique.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == unique.get(i)) {
                    if (itemOccurences == maxOccurences) {
                        list.remove(j);
                    } else {
                        itemOccurences++;
                    }
                }
            }
            itemOccurences = 0;
        }

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}

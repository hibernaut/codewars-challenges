package com.hibernaut.katas.rank_6kyu;

import java.util.HashMap;
import java.util.Map;

/**
 * Winter is coming, you must prepare your ski holidays.
 * The objective of this kata is to determine the number of pair of gloves you can
 * constitute from the gloves you have in your drawer.
 * <p>
 * Given an array describing the color of each glove, return the number of pairs you can constitute,
 * assuming that only gloves of the same color can form pairs.
 * Examples:
 * <p>
 * input = ["red", "green", "red", "blue", "blue"]
 * result = 2 (1 red pair + 1 blue pair)
 * <p>
 * input = ["red", "red", "red", "red", "red", "red"]
 * result = 3 (3 red pairs)
 */

public class PairOfGloves {
    public static int numberOfPairs(String[] gloves) {
        Map<String, Integer> gloveTypes = new HashMap<>();
        int glovePairs = 0;

        for (String s :
                gloves) {
            gloveTypes.merge(s, 1, (a, b) -> ++a);
        }

        for (Map.Entry<String, Integer> entry :
                gloveTypes.entrySet()) {
            entry.setValue(entry.getValue() / 2);
            glovePairs += entry.getValue();
        }

        return glovePairs;
    }
}

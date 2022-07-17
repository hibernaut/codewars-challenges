package com.hibernaut.katas.rank_6kyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Implement a function which creates a radix tree (a space-optimized trie [prefix tree])
 * in which each node that is the only child is merged with its parent
 * [unless a word from the input ends there]) from a given list of words using dictionaries
 * (aka hash maps or hash tables) where:
 *
 * The dictionary keys are the nodes.
 * Leaf nodes are empty dictionaries.
 * The value for empty input is an empty dictionary.
 * Words are all lowercase or empty strings.
 * Words can contain duplicates.
 * Examples:
 * Solution.radixTree()
 * // returns {}
 * Solution.radixTree("")
 * // returns {}
 * Solution.radixTree("", "")
 * // returns {}
 * Solution.radixTree("radix", "tree")
 * // returns {radix={}, tree={}}
 * Solution.radixTree("ape", "apple")
 * // returns {ap={e={}, ple={}}}
 * Solution.radixTree("apple", "applet", "apple", "ape")
 * // returns {ap={ple={t={}}, e={}}}
 * Solution.radixTree("romane", "romanus", "romulus", "rubens", "rubicon", "rubicundus")
 * // returns {r={om={an={e={}, us={}}, ulus={}}, ub={ens={}, ic={on={}, undus={}}}}}
 * Solution.radixTree("appleabcd", "apple")
 * // returns {apple={abcd={}}}
 */

public class RadixTree<K, V> {
    public static Map<String, Object> radixTree(String... words) {
        Map<String, Object> root = new HashMap<>();

        Arrays.sort(words);

        for (String word : words) {
            checkAndAdd(root, word);
        }

        return root;
    }

    private static void checkAndAdd(Map<String, Object> root, String word) {
        if(root.size() == 0 && word.length() > 0) {
            root.put(word, new HashMap<String, Object>());
            return;
        }

        int minLength;
        StringBuilder common = new StringBuilder();
        String keyString = null;
        Map<String, Object> temp = null;

        for (String key : root.keySet() ) {
            minLength = Math.min(key.length(), word.length());

            // Finding common string
            for (int i = 0; i < minLength; i++) {
                if(key.charAt(i) == word.charAt(i)) {
                    common.append(word.charAt(i));
                } else {
                    break;
                }
            }

            // The word and the key have common starting substring which is shorter both of them
            if(common.length() < minLength && common.length() > 0) {
                keyString = key;
                temp = (Map<String, Object>) root.get(key);
                break;
            }

            // The word starts with the key string
            else if(word.startsWith(key) && key.length() < word.length()) {
                checkAndAdd((Map<String, Object>) root.get(key), word.substring(key.length()));
                return;
            }

        }

        // Restructuring the node
        if (keyString != null) {
            // Removing subtree with the key string
            root.remove(keyString);

            // Adding the new subtree with common string instead of previous with the key string
            root.put(common.toString(), new HashMap<String, Object>());

            // Adding word substring to the subtree
            checkAndAdd((Map<String, Object>) root.get(common.toString()), word.substring(common.length()));

            // Adding existing subtree of the previous structure
            ((Map<String, Object>) root.get(common.toString())).put(keyString.substring(common.length()), temp);
        }

        // The word doesn't have any match with any key
        else if(word.length() > 0) {
            root.put(word, new HashMap<String, Object>());
        }
    }
}

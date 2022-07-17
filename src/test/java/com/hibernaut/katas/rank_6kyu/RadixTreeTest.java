package com.hibernaut.katas.rank_6kyu;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadixTreeTest {
    @Test
    @DisplayName("Example tests")
    void testSomething() {
        assertEquals(Map.of(), RadixTree.radixTree());
        assertEquals(Map.of(), RadixTree.radixTree(""));
        assertEquals(Map.of("abc", Map.of(), "def", Map.of(), "ghi", Map.of(), "jklm", Map.of(), "nop", Map.of()), RadixTree.radixTree("abc", "def", "ghi", "jklm", "nop"));
        assertEquals(Map.of("ap", Map.of("e", Map.of(), "ple", Map.of())), RadixTree.radixTree("ape", "apple"));
        assertEquals(Map.of("ap", Map.of("e", Map.of("l", Map.of()), "pendix", Map.of())), RadixTree.radixTree("ape", "appendix", "apel"));
        assertEquals(Map.of("ap", Map.of("e", Map.of(), "p", Map.of("le", Map.of("t", Map.of()), "endix", Map.of()))), RadixTree.radixTree("ape", "apple", "applet", "appendix"));
        assertEquals(Map.of("rom", Map.of("an", Map.of("e", Map.of(), "us", Map.of()), "ulus", Map.of())), RadixTree.radixTree("romane", "romanus", "romulus"));
        assertEquals(Map.of("r", Map.of("om", Map.of("an", Map.of("e", Map.of(), "us", Map.of()), "ulus", Map.of()), "ub", Map.of("ens", Map.of(), "ic", Map.of("on", Map.of(), "undus", Map.of())))), RadixTree.radixTree("romane", "romanus", "romulus", "rubens", "rubicon", "rubicundus"));
        assertEquals(Map.of("test", Map.of("er", Map.of("s", Map.of()))), RadixTree.radixTree("test", "tester", "testers"));
        assertEquals(Map.of("test", Map.of("er", Map.of("s", Map.of()))), RadixTree.radixTree("test", "tester", "testers", "tester"));
        assertEquals(Map.of("test", Map.of("er", Map.of("s", Map.of()))), RadixTree.radixTree("testers", "tester", "test"));
    }
}
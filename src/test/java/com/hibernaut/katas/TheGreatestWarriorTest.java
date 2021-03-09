package com.hibernaut.katas;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by hibernaut on 09.03.2021.
 */
public class TheGreatestWarriorTest {
    @Test
    public void sampleTest1() {

        TheGreatestWarrior tom = new TheGreatestWarrior();

        assertEquals(1, tom.level());
        assertEquals(100, tom.experience());
        assertEquals("Pushover", tom.rank());
    }

    @Test
    public void sampleTest2() {

        TheGreatestWarrior bruce_lee = new TheGreatestWarrior();

        assertEquals(1, bruce_lee.level());
        assertEquals(100, bruce_lee.experience());
        assertEquals("Pushover", bruce_lee.rank());
        assertEquals(new ArrayList<String>(), bruce_lee.achievements());
        assertEquals("Defeated Chuck Norris", bruce_lee.training("Defeated Chuck Norris", 9000, 1));
        assertEquals(9100, bruce_lee.experience());
        assertEquals(91, bruce_lee.level());
        assertEquals("Master", bruce_lee.rank());
        assertEquals("A good fight", bruce_lee.battle(90));
        assertEquals(9105, bruce_lee.experience());
        assertEquals(Arrays.asList("Defeated Chuck Norris"), bruce_lee.achievements());
    }
}

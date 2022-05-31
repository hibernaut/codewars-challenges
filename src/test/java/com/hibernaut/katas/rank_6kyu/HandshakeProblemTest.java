package com.hibernaut.katas.rank_6kyu;

import org.junit.Assert;
import org.junit.Test;

public class HandshakeProblemTest {
    @Test
    public void SampleTest()
    {
        Assert.assertEquals(0, HandshakeProblem.GetParticipants(0));
        Assert.assertEquals(2, HandshakeProblem.GetParticipants(1));
        Assert.assertEquals(3, HandshakeProblem.GetParticipants(3));
        Assert.assertEquals(4, HandshakeProblem.GetParticipants(6));
        Assert.assertEquals(5, HandshakeProblem.GetParticipants(7));
        Assert.assertEquals(254, HandshakeProblem.GetParticipants(31880));
    }
}

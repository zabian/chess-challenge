package pl.zaboklicki.chess;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChallengeTest {

    @Test
    public void testGame() throws Exception {
        Challenge challenge;
//        challenge = Challenge.builder(7, 7).kings(2).queens(2).bishops(2).knights(1).build();
        challenge = Challenge.builder(3, 3).kings(2).rooks(1).build();
        long start = System.currentTimeMillis();
        int solve = challenge.solve();
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms");
        assertEquals(3, solve);
    }
}
package com.nato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGuessTheNatoWordModel {
    private GuessTheNatoWordModel guessModel;

    @BeforeEach
    void setUp() {
        this.guessModel = new GuessTheNatoWordModel();
    }

    @Test
    void testWaitForNSecondsWithOne() {
        int seconds = 1;

        long startTime = System.currentTimeMillis();
        guessModel.waitForNSeconds(seconds);
        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= seconds * 1000, "guessModel.waitForNSeconds with parameter 1 should be true");
    }

    @Test
    void testWaitForNSecondsWithTwo() {
        int seconds = 2;

        long startTime = System.currentTimeMillis();
        guessModel.waitForNSeconds(seconds);
        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= seconds * 1000, "guessModel.waitForNSeconds with parameter 1 should be true");
    }

    @Test
    void testWaitForNSecondsWithThree() {
        int seconds = 3;

        long startTime = System.currentTimeMillis();
        guessModel.waitForNSeconds(seconds);
        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= seconds * 1000, "guessModel.waitForNSeconds with parameter 1 should be true");
    }

    @Test
    void testWaitForNSecondsWithFive() {
        int seconds = 5;

        long startTime = System.currentTimeMillis();
        guessModel.waitForNSeconds(seconds);
        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= seconds * 1000, "guessModel.waitForNSeconds with parameter 1 should be true");
    }

    @Test
    void testWaitForNSecondsWithTen() {
        int seconds = 10;

        long startTime = System.currentTimeMillis();
        guessModel.waitForNSeconds(seconds);
        long endTime = System.currentTimeMillis();

        assertTrue(endTime - startTime >= seconds * 1000, "guessModel.waitForNSeconds with parameter 1 should be true");
    }

    @Test
    void testGetIntroMessage() {
        String expectedIntro = """
                <html>
                    <p>Welcome to NATO Phonetic Alphabet!</p>
                    <p>This is a game to help you learn the NATO Phonetic Alphabet while having fun. You have 2 seconds to type the word equivalent to the letter shown, otherwise you'll lose. If you guess all words correctly, then you win the game.</p>
                    <p>The main idea for this project was taken from Reddit, namely, r/learnJava, but I designed and coded this program on my own while receiving feedback on my code from the reddit users u/NautiHooker, u/Nightcorex_ and u/geoffreychallen.</p>
                    <p>my post link: <a href="">https://www.reddit.com/r/learnjava/comments/wgwowp/how_can_i_improve_this_code/</p>
                    <p>Enjoy!</p>
                </html>
                """;

        assertEquals(expectedIntro, guessModel.getIntroMessage(), "getIntroMessage should be equal to expected message");
    }
}

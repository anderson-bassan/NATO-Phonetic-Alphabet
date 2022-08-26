package com.nato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}

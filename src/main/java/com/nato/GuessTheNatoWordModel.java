package com.nato;

public class GuessTheNatoWordModel {
    public void waitForNSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            System.out.println("Something went wrong while showing the intro. Exiting...");
            System.exit(0);
        }
    }
}

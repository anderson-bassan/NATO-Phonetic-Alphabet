package com.nato;

public class GuessTheNatoWordModel {
    private final MessageManager messageManager;

    public GuessTheNatoWordModel() {
        this.messageManager = new MessageManager();
    }

    public void waitForNSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            System.out.println("Something went wrong while showing the intro. Exiting...");
            System.exit(0);
        }
    }

    public String getIntroMessage() {
        return messageManager.INTRO_MESSAGE;
    }
}

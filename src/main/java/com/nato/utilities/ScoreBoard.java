package com.nato.utilities;

public class ScoreBoard {
    private int points;

    public ScoreBoard() {
        this.points = 0;
    }

    public void increasePoints() {
        points++;
    }

    public void decreasePoints() {
        if (points > 0) {
            points--;
        }
    }

    public int getPoints() {
        return points;
    }
}

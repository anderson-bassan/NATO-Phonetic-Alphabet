package com.nato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGuessTheNatoWordViewer {
    private GuessTheNatoWordViewer viewer;

    @BeforeEach
    void setup() {
        this.viewer  = new GuessTheNatoWordViewer();
    }

    @Test
    void testGetCurrentPanelWithIntroPanel() {
        this.viewer.setIntroPanel("intro");
        this.viewer.showIntroPanel();

        assertEquals("intro panel", this.viewer.getCurrentPanel(), "should equal intro panel");
    }

    @Test
    void testGetCurrentPanelWithGuessWordPanel() {
        this.viewer.setGuessWordPanel();
        this.viewer.showGuessWordPanel();

        assertEquals("guess word panel", this.viewer.getCurrentPanel(), "should equal guess word panel");
    }

    @Test
    void testGetCurrentPanelWithLosePanel() {
        this.viewer.setLosePanel();
        this.viewer.showLosePanel();

        assertEquals("lose panel", this.viewer.getCurrentPanel(), "should equal lose panel");
    }

    @Test
    void testGetCurrentPanelWithWinPanel() {
        this.viewer.setWinPanel(00);
        this.viewer.showWinPanel();

        assertEquals("win panel", this.viewer.getCurrentPanel(), "should equal win panel");
    }
}

package com.nato;

public class GuessTheNatoWordController {
    GuessTheNatoWordViewer viewer;
    GuessTheNatoWordModel model;

    GuessTheNatoWordController(GuessTheNatoWordViewer viewer, GuessTheNatoWordModel model) {
        this.viewer = viewer;
        this.model = model;

        run();
    }

    void run() {
        viewer.setIntro(model.getIntroMessage());
        viewer.showIntro();
        model.waitForNSeconds(5);
        viewer.removePanel();
    }
}

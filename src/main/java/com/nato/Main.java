/*
 * @author Anderson Bassan
 *
*/


package com.nato;


public class Main {
	public static void main(String[] args) {
		var textManager = new TextManager();

		var guessTheNatoWordViewer = new GuessTheNatoWordViewer(textManager.INTRO_MESSAGE);
		var guessTheNatoWordModel = new GuessTheNatoWordModel();
		var guessTheNatoWordController = new GuessTheNatoWordController(guessTheNatoWordViewer, guessTheNatoWordModel);

		guessTheNatoWordController.run();
	}
}
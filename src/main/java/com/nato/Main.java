/*
 * @author Anderson Bassan
 *
*/


package com.nato;


public class Main {
	public static void main(String[] args) {
		var guessTheNatoWordViewer = new GuessTheNatoWordViewer();
		var guessTheNatoWordModel = new GuessTheNatoWordModel();
		var guessTheNatoWordController = new GuessTheNatoWordController(guessTheNatoWordViewer, guessTheNatoWordModel);

		guessTheNatoWordController.run();
	}
}
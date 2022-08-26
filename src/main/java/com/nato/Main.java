/*
 * @author Anderson Bassan
 *
*/


package com.nato;


public class Main {
	public static void main(String[] args) {
		var textManager = new TextManager();

		var guessTheNatoWord = new GuessTheNatoWordViewer(textManager.INTRO_MESSAGE);

		guessTheNatoWord.play();
	}
}
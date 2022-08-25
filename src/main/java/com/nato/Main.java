/*
 * @author Anderson Bassan
 *
*/


package com.nato;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
	public static void main(String[] args) {
		var textManager = new TextManager();

		var viewer = new Viewer();

		var guessTheNatoWord = new GuessTheNatoWordApp(textManager.INTRO_MESSAGE, viewer);

		guessTheNatoWord.play();
	}
}
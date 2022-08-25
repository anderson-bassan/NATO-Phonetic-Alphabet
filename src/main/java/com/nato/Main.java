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
		var inputReader = new InputReader(new BufferedReader(new InputStreamReader(System.in)));
		var natoPhoneticAlphabet = new NATOPhoneticAlphabet();
		var wordManager = new WordManager(natoPhoneticAlphabet, new RandomCharacterGenerator(new Random(), natoPhoneticAlphabet.getKeys()));
		var levenshteinAlgorithm = new LevenshteinAlgorithm(3);


		var timedOutUserInput = new TimedOutUserInput(
				inputReader,
				2,
				SECONDS,
				textManager.EXIT_MESSAGE,
				textManager.TIME_OUT_MESSAGE);

   		var points = new Points(
				textManager.CURRENT_POINTS_MESSAGE,
				textManager.FINAL_POINTS_MESSAGE,
				textManager.WIN_MESSAGE,
				textManager.LOSE_MESSAGE,
				textManager.LOSE_BY_TIMEOUT_MESSAGE);

		var guessTheNatoWord = new GuessTheNatoWord(
				textManager.INTRO,
				wordManager,
				levenshteinAlgorithm,
				timedOutUserInput,
				points);


		guessTheNatoWord.play();
    }
}
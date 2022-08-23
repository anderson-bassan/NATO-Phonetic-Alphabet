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
		var timedOutUserInput = new TimedOutUserInput(inputReader, 2, SECONDS, "exit", "time out");
   		var points = new Points("your current points are", "you finished with a score of", "you own", "game over", "you lost by timeout");

		var guessTheNatoWord = new GuessTheNatoWord(textManager, wordManager, levenshteinAlgorithm, timedOutUserInput, points);

		guessTheNatoWord.play();
    }
}
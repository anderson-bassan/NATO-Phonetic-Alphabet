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
		var inputReader = new InputReader(new BufferedReader(new InputStreamReader(System.in)));
		var natoPhoneticAlphabet = new NATOPhoneticAlphabet();
		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), natoPhoneticAlphabet);
		var levenshteinAlgorithm = new LevenshteinAlgorithm(3);
		var timedOutUserInput = new TimedOutUserInput(inputReader, 3, SECONDS, "You took to long to answer and lost.", "exit");
   		var guessTheNatoWord = new GuessTheNatoWord(natoPhoneticAlphabet, randomCharacterGenerator, levenshteinAlgorithm, timedOutUserInput);

		guessTheNatoWord.play();
    }
}

package com.nato;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
		var natoPhoneticAlphabet = new NATOPhoneticAlphabet();
		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), natoPhoneticAlphabet);
		var levenshteinAlgorithm = new LevenshteinAlgorithm(3);

   		var guessTheNatoWord = new GuessTheNatoWord(natoPhoneticAlphabet, randomCharacterGenerator, levenshteinAlgorithm);

		guessTheNatoWord.play();
    }
}

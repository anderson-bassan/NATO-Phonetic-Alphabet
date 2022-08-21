package com.nato;

import java.util.Random;

public class RandomCharacterGenerator {
    private static Random randomGenerator;
	private static NATOPhoneticAlphabet natoPhoneticAlphabet;
	private static char previousRandomChar;
	private static char randomChar;
	
	public RandomCharacterGenerator(Random randomGenerator, NATOPhoneticAlphabet natoPhoneticAlphabet) {
		this.randomGenerator = randomGenerator;
		this.natoPhoneticAlphabet = natoPhoneticAlphabet;
		this.previousRandomChar = '`';
		this.randomChar = previousRandomChar;
	}
	
	public void generateRandom() {
		int randomCharIndex = randomGenerator.nextInt(natoPhoneticAlphabet.getSize());
		Character[] availableWordsSymbols = natoPhoneticAlphabet.getKeys();

		// if the random char is precedes, follows or is the same as the previous random char then generate a new one
		if (2 <= natoPhoneticAlphabet.getSize() && (previousRandomChar == (char) (availableWordsSymbols[randomCharIndex] - 1) || previousRandomChar == (char) (availableWordsSymbols[randomCharIndex] + 1) || previousRandomChar == (char) (availableWordsSymbols[randomCharIndex]))) {
			generateRandom();
			
		} else {
			randomChar = availableWordsSymbols[randomCharIndex];
			previousRandomChar = randomChar;
		}
	}
	
	public char getRandom() {
		return randomChar;
	}
}
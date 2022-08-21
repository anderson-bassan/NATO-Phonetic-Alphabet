package com.nato;


import java.util.Random;


public class WordManager {
	private final NATOPhoneticAlphabet NATO;
	private final RandomCharacterGenerator RANDOM_CHAR_GENERATOR;
	private String correctWord;
	private char correctSymbol;

	public WordManager(NATOPhoneticAlphabet nato, RandomCharacterGenerator randomCharacterGenerator) {
		this.NATO = nato;
		this.RANDOM_CHAR_GENERATOR = randomCharacterGenerator;

		this.correctWord = "";
		this.correctSymbol = '`';
	}
	
	public void generateRandomCorrectword() {
		RANDOM_CHAR_GENERATOR.generateRandom();
		correctSymbol = RANDOM_CHAR_GENERATOR.getRandom();
		correctWord = NATO.getByKey(correctSymbol);
	}
	
	public String getCorrectWord() {
		return correctWord;
	}

	public char getCorrectWordSymbol() {
		return correctSymbol;
	}
	
	public void removeCorrectWord() {
		NATO.removeByKey(correctSymbol);
		RANDOM_CHAR_GENERATOR.removeSymbol(correctSymbol);
	}
	
	public boolean isEmpty() {
		return (NATO.getSize() == 0);
	}
}
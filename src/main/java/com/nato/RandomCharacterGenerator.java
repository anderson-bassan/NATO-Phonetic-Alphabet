package com.nato;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class RandomCharacterGenerator {
    private final Random RANDOM_GENERATOR;
	private List<Character> symbols;
	private char previousRandomChar;
	private char randomChar;
	
	public RandomCharacterGenerator(Random randomGenerator, List<Character> symbols) {
		this.RANDOM_GENERATOR = randomGenerator;
		this.symbols = symbols;

		this.previousRandomChar = '`';
		this.randomChar = this.previousRandomChar;
	}
	
	public void generateRandom() {
		int randomSymbolIndex = RANDOM_GENERATOR.nextInt(symbols.size());
		randomChar = symbols.get(randomSymbolIndex);

		if (symbols.size() >= 2) {
			if (previousRandomChar == (char) randomChar - 1) {
				generateRandom();

			} else if (previousRandomChar == (char) randomChar + 1) {
				generateRandom();

			} else if (previousRandomChar == randomChar){
				generateRandom();
			
			} else {
				previousRandomChar = randomChar;
			}
		
		} else {
			previousRandomChar = randomChar;

		}
	}

	public void removeSymbol(char symbol) {
		symbols.remove(Character.valueOf(symbol));
	}
	
	public char getRandom() {
		return randomChar;
	}
}
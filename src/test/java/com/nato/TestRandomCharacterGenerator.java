package com.nato;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class TestRandomCharacterGenerator {
	@Mock
	List<Character> mockList;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
 		this.mockList = new ArrayList<Character>();
	}
	
	@Test
	@DisplayName("test get random with only 1 char")
	void testGetRandomWithOnlyA() {
		mockList.add('a');
		
		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), mockList);
		
		randomCharacterGenerator.generateRandom();
		assertEquals('a', randomCharacterGenerator.getRandom(), "get random should equal a");
	}

 	@Test
	@DisplayName("test get random with only 2 chars")
	void testGetRandomWithOnlyAAndB() {
		mockList.add('a');
		mockList.add('b');

		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), mockList);
		List<Character> alphabet = new ArrayList<Character>();
		alphabet.add('a');
		alphabet.add('b');
		
		randomCharacterGenerator.generateRandom();
		assertThat("get random with a or b should be equal to a or b", alphabet, hasItem(randomCharacterGenerator.getRandom()));
	}

	@Test
	@DisplayName("test remove symbol with only 2 chars")
	void removeARandomCharacter() {
		mockList.add('a');
		mockList.add('b');

		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), mockList);
		randomCharacterGenerator.removeSymbol('b');
		randomCharacterGenerator.generateRandom();
 		assertEquals('a', randomCharacterGenerator.getRandom(), "after removing b from a, b symbols random should return a");
	}

	@Test
	@DisplayName("test get random with all chars")
	void testGetRandomWithRealNATOPhoneticAlphabet() {
		var nato = new NATOPhoneticAlphabet();
		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), nato.getKeys());
		List<Character> alphabet = new ArrayList<Character>();
		alphabet.add('0');
		alphabet.add('1');
		alphabet.add('2');
		alphabet.add('3');
		alphabet.add('4');
		alphabet.add('5');
		alphabet.add('6');
		alphabet.add('7');
		alphabet.add('8');
		alphabet.add('9');
		alphabet.add('a');
		alphabet.add('b');
		alphabet.add('c');
		alphabet.add('d');
		alphabet.add('e');
		alphabet.add('f');
		alphabet.add('g');
		alphabet.add('h');
		alphabet.add('i');
		alphabet.add('j');
		alphabet.add('k');
		alphabet.add('l');
		alphabet.add('m');
		alphabet.add('n');
		alphabet.add('o');
		alphabet.add('p');
		alphabet.add('q');
		alphabet.add('r');
		alphabet.add('s');
		alphabet.add('t');
		alphabet.add('u');
		alphabet.add('v');
		alphabet.add('w');
		alphabet.add('x');
		alphabet.add('y');
		alphabet.add('z');

		randomCharacterGenerator.generateRandom();
		assertThat("get random with real object should be within 0-9a-z", alphabet, hasItem(randomCharacterGenerator.getRandom()));
	}
}
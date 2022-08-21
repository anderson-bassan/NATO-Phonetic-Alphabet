package com.nato;


import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.when;


public class TestWordManager {
 	WordManager wordManager;
	List<String> words;
	NATOPhoneticAlphabet nato;

	@BeforeEach
	void setup() {
		this.nato = new NATOPhoneticAlphabet();
		this.wordManager = new WordManager(nato, new RandomCharacterGenerator(new Random(), nato.getKeys()));
		this.words = new ArrayList<String>();
	}

	@Test
	@DisplayName("empty array get correct word should return \"\"")
	void testGetCorrectWord() {
		assertEquals("", wordManager.getCorrectWord());
	}
	
	@Test
	@DisplayName("the generated correct word should return one of the nato phonetic words")
	void testGenerateCorrectWordAndGetCorrectWord() {
		words.add("alpha");
		words.add("bravo");
		words.add("charlie");
		words.add("delta");
		words.add("echo");
		words.add("foxtrot");
		words.add("golf");
		words.add("hotel");
		words.add("india");
		words.add("juliet");
		words.add("kilo");
		words.add("lima");
		words.add("mike");
		words.add("november");
		words.add("oscar");
		words.add("papa");
		words.add("quebec");
		words.add("romeo");
		words.add("sierra");
		words.add("tango");
		words.add("uniform");
		words.add("victor");
		words.add("whiskey");
		words.add("xray");
		words.add("yankee");
		words.add("zulu");
		words.add("zero");
		words.add("one");
		words.add("two");
		words.add("three");
		words.add("four");
		words.add("five");
		words.add("six");
		words.add("seven");
		words.add("eight");
		words.add("nine");
		
		wordManager.generateRandomCorrectword();
		assertThat(words, hasItem(wordManager.getCorrectWord()));
	}

	@Test
	@DisplayName("get correct word with only alpha should return alpha")
	void testGetCorrectWordWithOnlyAlpha() {
		List<Character> fakeKeys = new ArrayList<Character>();
		fakeKeys.add('a');

		var psudoWordManager = new WordManager(nato, new RandomCharacterGenerator(new Random(), fakeKeys));

		psudoWordManager.generateRandomCorrectword();
		assertEquals("alpha", psudoWordManager.getCorrectWord(), "get correct word should return alpha");
	}

	@Test
	@DisplayName("get correct word and get correct symbol should match")
	void testGetCorrectWordSymbol() {
		wordManager.generateRandomCorrectword();
		assertEquals(wordManager.getCorrectWord(), nato.getByKey(wordManager.getCorrectWordSymbol()));
	}
	
	@Test
	@DisplayName("get correct word symbol with only alpha should return a")
	void testGetCorrectWordSymbolWihOnlyAlpha() {
		List<Character> fakeKeys = new ArrayList<Character>();
		fakeKeys.add('a');

		var psudoWordManager = new WordManager(nato, new RandomCharacterGenerator(new Random(), fakeKeys));

		psudoWordManager.generateRandomCorrectword();
		assertEquals('a', psudoWordManager.getCorrectWordSymbol(), "get correct word symbol should return a");
	}
	
	@Test
	@DisplayName("remove correct word should return alpha or bravo, after removing one of them randomly")
	void testRemoveCorrectWord() {
		List<Character> fakeKeys = new ArrayList<Character>();
		fakeKeys.add('a');
		fakeKeys.add('b');

		var psudoWordManager = new WordManager(nato, new RandomCharacterGenerator(new Random(), fakeKeys));

		psudoWordManager.generateRandomCorrectword();
		psudoWordManager.removeCorrectWord();
		assertThat("get correct word symbol should return a", Arrays.asList("alpha", "bravo"), hasItem(psudoWordManager.getCorrectWord()));
	}
	
	@Test
	@DisplayName("is empty should return false with initial obj")
	void testIsEmptyShouldReturnFalseWhenFull() {
		assertFalse(wordManager.isEmpty());
	}
	
	@Test
	@DisplayName("is empty should return true with empty obj")
	void testIsEmptyShouldReturnTrueWhenEmpty() {
		for(int i = 0; i < 36; i++) {
			wordManager.generateRandomCorrectword();
			wordManager.removeCorrectWord();
		}

		assertTrue(wordManager.isEmpty());
	}

}
package com.nato;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class TestNATOPhoneticAlphabet {
	NATOPhoneticAlphabet natoAlphabet;
	List<Character> alphabet;
	
	@BeforeEach
	void build() {
		this.natoAlphabet = new NATOPhoneticAlphabet();
 		this.alphabet = new ArrayList();
		
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
	}
	
 	@Test
	@DisplayName("test get size")
	void testGetSize() {
		assertEquals(36, natoAlphabet.getSize(), "get size should equal 36");
	}
	
	@Test
	@DisplayName("test get keys")
	void testGetKeys() {
		assertArrayEquals(alphabet.toArray(new Character[36]), natoAlphabet.getKeys(), "get keys shoud be equal to [0-9a-z]");
	}
	
	@Test 
	@DisplayName("test get key")
	void testGetByKey() {
		assertAll(
		() -> assertEquals("alpha", natoAlphabet.getByKey('a'), "get by key with parameter a should equal alpha"),
		() -> assertEquals("bravo", natoAlphabet.getByKey('b'), "get by key with parameter b should equal bravo"),
		() -> assertEquals("charlie", natoAlphabet.getByKey('c'), "get by key with parameter c should equal charlie"),
		() -> assertEquals("delta", natoAlphabet.getByKey('d'), "get by key with parameter d should equal delta"),
		() -> assertEquals("echo", natoAlphabet.getByKey('e'), "get by key with parameter e should equal echo"),
		() -> assertEquals("foxtrot", natoAlphabet.getByKey('f'), "get by key with parameter f should equal foxtrot"),
		() -> assertEquals("golf", natoAlphabet.getByKey('g'), "get by key with parameter g should equal golf"),
		() -> assertEquals("hotel", natoAlphabet.getByKey('h'), "get by key with parameter h should equal hotel"),
		() -> assertEquals("india", natoAlphabet.getByKey('i'), "get by key with parameter i should equal india"),
		() -> assertEquals("juliet", natoAlphabet.getByKey('j'), "get by key with parameter j should equal juliet"),
		() -> assertEquals("kilo", natoAlphabet.getByKey('k'), "get by key with parameter k should equal kilo"),
		() -> assertEquals("lima", natoAlphabet.getByKey('l'), "get by key with parameter l should equal lima"),
		() -> assertEquals("mike", natoAlphabet.getByKey('m'), "get by key with parameter m should equal mike"),
		() -> assertEquals("november", natoAlphabet.getByKey('n'), "get by key with parameter n should equal november"),
		() -> assertEquals("oscar", natoAlphabet.getByKey('o'), "get by key with parameter o should equal oscar"),
		() -> assertEquals("papa", natoAlphabet.getByKey('p'), "get by key with parameter p should equal papa"),
		() -> assertEquals("quebec", natoAlphabet.getByKey('q'), "get by key with parameter q should equal quebec"),
		() -> assertEquals("romeo", natoAlphabet.getByKey('r'), "get by key with parameter r should equal romeo"),
		() -> assertEquals("sierra", natoAlphabet.getByKey('s'), "get by key with parameter s should equal sierra"),
		() -> assertEquals("tango", natoAlphabet.getByKey('t'), "get by key with parameter t should equal tango"),
		() -> assertEquals("uniform", natoAlphabet.getByKey('u'), "get by key with parameter u should equal uniform"),
		() -> assertEquals("victor", natoAlphabet.getByKey('v'), "get by key with parameter v should equal victor"),
		() -> assertEquals("whiskey", natoAlphabet.getByKey('w'), "get by key with parameter w should equal whiskey"),
		() -> assertEquals("xray", natoAlphabet.getByKey('x'), "get by key with parameter x should equal xray"),
		() -> assertEquals("yankee", natoAlphabet.getByKey('y'), "get by key with parameter y should equal yankee"),
		() -> assertEquals("zulu", natoAlphabet.getByKey('z'), "get by key with parameter z should equal zulu"),
		() -> assertEquals("zero", natoAlphabet.getByKey('0'), "get by key with parameter 0 should equal zero"),
		() -> assertEquals("one", natoAlphabet.getByKey('1'), "get by key with parameter 1 should equal one"),
		() -> assertEquals("two", natoAlphabet.getByKey('2'), "get by key with parameter 2 should equal two"),
		() -> assertEquals("three", natoAlphabet.getByKey('3'), "get by key with parameter 3 should equal three"),
		() -> assertEquals("four", natoAlphabet.getByKey('4'), "get by key with parameter 4 should equal four"),
		() -> assertEquals("five", natoAlphabet.getByKey('5'), "get by key with parameter 5 should equal five"),
		() -> assertEquals("six", natoAlphabet.getByKey('6'), "get by key with parameter 6 should equal six"),
		() -> assertEquals("seven", natoAlphabet.getByKey('7'), "get by key with parameter 7 should equal seven"),
		() -> assertEquals("eight", natoAlphabet.getByKey('8'), "get by key with parameter 8 should equal eight"),
		() -> assertEquals("nine", natoAlphabet.getByKey('9'), "get by key with parameter 9 should equal nine"),
 		() -> assertThrows(NullPointerException.class, () -> natoAlphabet.getByKey('`'), "get by key with invalid parameter should equal null")
		);
	}
	
	@Test 
	@DisplayName("test remove by key size")
	void testRemoveByKeySize() {
		for (int i = 0; i < alphabet.size(); i++) {
			String errorMessage = String.format("after removing %c key from the map, size should be %d", alphabet.get(i), i);
			
			// gets a key from 0 to 9 and a to z and removes it
			natoAlphabet.removeByKey(alphabet.get(i));
			// asserts that the key was removed from the array by the array size
			assertEquals(35 - i, natoAlphabet.getSize(), errorMessage);
		}
	}

	@Test 
	@DisplayName("test remove by key keys")
	void testRemoveByKeyKeys() {
		for (int i = 0; i < 1; i++) {
			String errorMessage = String.format("when %c is removed keys should be equal", alphabet.get(i));
			
			natoAlphabet.removeByKey(alphabet.get(i));
			// creates a correct array with the removed key
			alphabet.remove(Character.valueOf(alphabet.get(i)));
			
			// verifies if the key was correctly removed from the keys
			assertArrayEquals(alphabet.toArray(new Character[35 - i]), natoAlphabet.getKeys(), errorMessage);
		}
	}
}
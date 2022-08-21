package com.nato;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class NATOPhoneticAlphabet {
    private HashMap<Character, String> natoPhoneticAlphabet = new HashMap<Character, String>();
	
	public NATOPhoneticAlphabet() {
		// sets the initial values for the map
		
		natoPhoneticAlphabet.put('a', "alpha");
		natoPhoneticAlphabet.put('b', "bravo");
 		natoPhoneticAlphabet.put('c', "charlie");
		natoPhoneticAlphabet.put('d', "delta");
 		natoPhoneticAlphabet.put('e', "echo");
		natoPhoneticAlphabet.put('f', "foxtrot");
		natoPhoneticAlphabet.put('g', "golf");
		natoPhoneticAlphabet.put('h', "hotel");
		natoPhoneticAlphabet.put('i', "india");
		natoPhoneticAlphabet.put('j', "juliet");
		natoPhoneticAlphabet.put('k', "kilo");
		natoPhoneticAlphabet.put('l', "lima");
		natoPhoneticAlphabet.put('m', "mike");
		natoPhoneticAlphabet.put('n', "november");
		natoPhoneticAlphabet.put('o', "oscar");
		natoPhoneticAlphabet.put('p', "papa");
		natoPhoneticAlphabet.put('q', "quebec");
		natoPhoneticAlphabet.put('r', "romeo");
		natoPhoneticAlphabet.put('s', "sierra");
		natoPhoneticAlphabet.put('t', "tango");
		natoPhoneticAlphabet.put('u', "uniform");
		natoPhoneticAlphabet.put('v', "victor");
		natoPhoneticAlphabet.put('w', "whiskey");
		natoPhoneticAlphabet.put('x', "xray");
		natoPhoneticAlphabet.put('y', "yankee");
		natoPhoneticAlphabet.put('z', "zulu");
		natoPhoneticAlphabet.put('0', "zero");
		natoPhoneticAlphabet.put('1', "one");
		natoPhoneticAlphabet.put('2', "two");
		natoPhoneticAlphabet.put('3', "three");
		natoPhoneticAlphabet.put('4', "four");
		natoPhoneticAlphabet.put('5', "five");
		natoPhoneticAlphabet.put('6', "six");
		natoPhoneticAlphabet.put('7', "seven");
		natoPhoneticAlphabet.put('8', "eight");
		natoPhoneticAlphabet.put('9', "nine");
	}
	
	public int getSize() {
		return natoPhoneticAlphabet.size();
	}
	
	public List<Character> getKeys() {
		List<Character> keys = new ArrayList<Character>();
		keys.addAll(natoPhoneticAlphabet.keySet());
		return keys;
	}
	
	public String getByKey(char key) throws NullPointerException {
		if (natoPhoneticAlphabet.get(key) == null) {
			throw new NullPointerException("invalid key");
		}
		
		return natoPhoneticAlphabet.get(key);
	}
	
	public void removeByKey(char key) {
		natoPhoneticAlphabet.remove(key);
	}
}
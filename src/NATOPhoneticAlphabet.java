// import for handling maps
import java.util.HashMap;
import java.util.ArrayList;

// import for generating random numbers
import java.util.Random;

// imports for handling user input
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NATOPhoneticAlphabet {
    private HashMap<Character, String> natoPhoneticAlphabet = new HashMap<Character, String>();

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final Random randomGenerator = new Random();
	
	private char randomChar;
 	private String randomWord;
    private int points = 0;

	public NATOPhoneticAlphabet() {
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

 	private void setRandomChar() {
		int charIndex = randomGenerator.nextInt(natoPhoneticAlphabet.size());
		Character[] alphabet = natoPhoneticAlphabet.keySet().toArray(new Character[natoPhoneticAlphabet.size()]);

		randomChar = alphabet[charIndex];
	}
	
 	private void setRandomWord() {
		setRandomChar();
		randomWord = natoPhoneticAlphabet.get(randomChar);
	}
	
	private void showCorrectAnswer() {
		System.out.printf("%nThe correct word is %s.%n", randomWord);
	}
	
	private void showPoints() {
		String filledLine = "";
		String borderLine = "#";
		for (int i = 0; i < 36; i++) filledLine += "#";
		for (int i = 0; i < 34; i++) borderLine += " ";
		borderLine += "#";
		
		System.out.printf("%n%n%s%n", filledLine);
		System.out.printf("%s%n", borderLine);
		
		if (points < 10) {
			System.out.printf("#    Your current points are %d     #%n", points);
		
		} else {
			System.out.printf("#    Your current points are %d    #%n", points);
		}
		
		System.out.printf("%s%n", borderLine);
		System.out.printf("%s%n%n", filledLine);
	}
	
	private void finalPoints() {	
		String filledLine = "";
		String borderLine = "#";
		for (int i = 0; i < 36; i++) filledLine += "#";
		for (int i = 0; i < 34; i++) borderLine += " ";
		borderLine += "#";

		System.out.printf("%n%n%s%n", filledLine);	
		System.out.println("#             GAME OVER            #");
		System.out.printf("%s%n%n", filledLine);
		
		System.out.printf("%n%n%s%n", filledLine);
		System.out.printf("%s%n", borderLine);
		
		if (points < 10) {
			System.out.printf("#    You final score was %d         #%n", points);
		
		} else {
			System.out.printf("#    You final score was %d        #%n", points);
		}
		
		System.out.printf("%s%n", borderLine);
		System.out.printf("%s%n%n", filledLine);
	}
	
	private String getInput() {
		try {
			return br.readLine().toLowerCase();
		
		} catch (IOException e) {
			e.printStackTrace();
			return "exit";
		}
	}

	private boolean guess() {	
 		setRandomWord();
		System.out.printf("What is the word for %c (exit to exit): ", randomChar);
		String inputWord = getInput();
		
		if (inputWord.equals("exit")) return false;
		
		if (inputWord.equals(randomWord)) {
			natoPhoneticAlphabet.remove(randomChar, randomWord); // remove word from possible words
			points++;
			
			if (natoPhoneticAlphabet.size() == 0) {
				return false;
			}
		
		} else {
			showCorrectAnswer();
			points--;
		}

		showPoints();	
		
		return true;
	}

	public void play() {	
		while (guess());
		finalPoints();
	}
}

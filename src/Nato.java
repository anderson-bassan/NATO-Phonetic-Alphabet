import java.util.Map;
import static java.util.Map.entry;

import java.util.Random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Nato {
    private static final Map<Character, String> natoAlphabet = Map.ofEntries(
            entry('a', "alpha"),
            entry('b', "bravo"),
            entry('c', "charlie"),
            entry('d', "delta"),
            entry('e', "echo"),
            entry('f', "foxtrot"),
            entry('g', "golf"),
            entry('h', "hotel"),
            entry('i', "india"),
            entry('j', "juliet"),
            entry('k', "kilo"),
            entry('l', "lima"),
            entry('m', "mike"),
            entry('n', "november"),
            entry('o', "oscar"),
            entry('p', "papa"),
            entry('q', "quebec"),
            entry('r', "romeo"),
            entry('s', "sierra"),
            entry('t', "tango"),
            entry('u', "uniform"),
            entry('v', "victor"),
            entry('w', "whiskey"),
            entry('x', "xray"),
            entry('y', "yankee"),
            entry('z', "zulu"),
			entry('0', "zero"),
			entry('1', "one"),
			entry('2', "two"),
			entry('3', "three"),
			entry('4', "four"),
			entry('5', "five"),
			entry('6', "six"),
			entry('7', "seven"),
			entry('8', "eight"),
			entry('9', "nine")
    );

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final Random rand = new Random();
	
	private char randomChar;
	private String randomWord;
    private int points = 0;

	private void setRandomChar() {
		int c = rand.nextInt(natoAlphabet.size()); // generates a random char between 0 and 35
		randomChar =  (c < 26) ? (char) ('a' + c) : (char) ('0' + c - 26); // return the equivalent letter or number
	}
	
	private void setRandomWord() {
		setRandomChar();
		randomWord = natoAlphabet.get(randomChar);
	}
	
	private void showCorrectAnswer() {
		System.out.printf("%nThe correct word is %s.%n", randomWord);
	}
	
	private void showPoints() {
		System.out.printf("%n%n%n%n%n%nYour current points are %d.%n%n%n%n%n%n%n", points);
	}
	
	private String getInput() {
		try {
			return br.readLine().toLowerCase();
		
		} catch (IOException e) {
			e.printStackTrace();
			return "exit";
		}
	}


	public boolean guess() {	
		setRandomWord();
		System.out.printf("What is the word for %c (exit to exit): ", randomChar);
		String inputWord = getInput();
		
		if (inputWord.equals("exit")) return false;
		
		if (inputWord.equals(randomWord)) {
			points++;
		
		} else {
			showCorrectAnswer();
			points--;
		}

		showPoints();	

		return true;
	}
	
	public void play() {
		while (guess());
		
		System.out.printf("Total points: %d.%n", points);
	}
}

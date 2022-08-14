// import for handling maps
import java.util.HashMap;
import java.util.ArrayList;

// import for generating random numbers
import java.util.Random;

// imports for scheduling tasks
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class NATOPhoneticAlphabet {
    private HashMap<Character, String> natoPhoneticAlphabet = new HashMap<Character, String>();

    private final Random randomGenerator = new Random();
	
	private char previousChar = '`';
	private char randomChar;
 	private String randomWord;
    private int points = 0;
	
	private int TIMEOUT_SECONDS = 3;

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

		if (previousChar == (char) (alphabet[charIndex] - 1) || previousChar == (char) (alphabet[charIndex] + 1)) {
			// if the last char is too similar to the previous random char generates a new one
			setRandomChar();
			
		} else {
			// this generates a char in the first run or if the char is random enough. Surprisingly it nevers softlock 
			randomChar = alphabet[charIndex];
			previousChar = randomChar;
		}
	}
	
 	private void setRandomWord() {
		setRandomChar();
		randomWord = natoPhoneticAlphabet.get(randomChar);
	}
	
	private void showCorrectAnswer() {
		System.out.printf("%nThe correct word is %s.%n", randomWord);
	}
	
	private void showPoints() {
		System.out.println("");
		System.out.println("");
		System.out.println("####################################");
		System.out.println("#                                  #");
		
		if (0 <= points && points < 10) {
			System.out.printf("#    Your current points are %d     #%n", points);
		
		} else {
			System.out.printf("#    Your current points are %d    #%n", points);
		}

		System.out.println("#                                  #");
		System.out.println("####################################");
		System.out.println("");
		System.out.println("");
	}
	
	private void finalPoints() {	
		System.out.println("");
		System.out.println("");
		System.out.println("####################################");
		System.out.println("#             GAME OVER            #");
		System.out.println("####################################");
		System.out.println("");
		System.out.println("");		
		System.out.println("####################################");
		System.out.println("#                                  #");

		if (0 <= points && points < 10) {
			System.out.printf("#    You final score was %d         #%n", points);
		
		} else {
			System.out.printf("#    You final score was %d        #%n", points);
		}		

		System.out.println("#                                  #");
		System.out.println("####################################");
	}
	
	private String getInput() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		InputReader inputReader = new InputReader();
		Future<String> result = executor.submit(inputReader);
		
		try {
			return result.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
		} catch(ExecutionException | InterruptedException | TimeoutException e) {
			return "exit";
		} finally {
			executor.shutdown();
		}
		
/* 		try {
			return br.readLine().toLowerCase();
		
		} catch (IOException e) {
			e.printStackTrace();
			return "exit";
		} */
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
		try {
			System.out.printf("%n%nWelcome to NATO Phonetic Alphabet%n%n");
			Thread.sleep(3000);
			System.out.printf("This is a game to help you learn the NATO Phonetic Alphabet while having fun.%n%n");
			Thread.sleep(3000);
			System.out.printf("You have %d seconds to type the word equivalent to the letter shown, otherwise you'll lose.%n", TIMEOUT_SECONDS);
			System.out.printf("If you get all words correctly, then you win the game.%n");
			Thread.sleep(4000);
			System.out.printf("Enjoy!%n");
			Thread.sleep(4000);
			System.out.printf("                                                              - Created by Anderson Bassan%n%n%n");
		} catch (InterruptedException e) {}
		
		while (guess());
		finalPoints();
		System.exit(0);
	}
}

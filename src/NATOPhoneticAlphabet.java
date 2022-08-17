import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class NATOPhoneticAlphabet {
    private HashMap<Character, String> natoPhoneticAlphabet = new HashMap<Character, String>();
	
    private final Random randomGenerator = new Random();
	
	private char previousRandomChar = '`';
	private char randomChar;
    private int points = 0;
	
	private static final int INPUT_TIMEOUT_SECONDS = 3;

	private static final LevenshteinAlgorithm lev = new LevenshteinAlgorithm();
	private static final int MAXIMUM_ACCEPTED_DISTANCE = 2;

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

	public void showIntro() {
		// show an intro explaining the project
		
		try {
			System.out.printf("%n%n\tWelcome to NATO Phonetic Alphabet%n%n");
			Thread.sleep(3000);
			System.out.printf("\tThis is a game to help you learn the NATO Phonetic Alphabet while having fun.%n%n");
			Thread.sleep(3000);
			System.out.printf("\tYou have %d seconds to type the word equivalent to the letter shown, otherwise you'll lose.%n", INPUT_TIMEOUT_SECONDS);
			System.out.printf("\tIf you get all words correctly, then you win the game.%n%n");
			Thread.sleep(5000);
			System.out.printf("\tThe main idea for this project was taken from Reddit, namely, r/learnJava, but I designed and coded this%n");
			System.out.printf("\tprogram on my own while receiving feedback on my code from the reddit users u/NautiHooker, u/Nightcorex_.%n");
			System.out.printf("\tand u/geoffreychallen.%n%n");
			Thread.sleep(6000);
			System.out.printf("\tmy post link: https://www.reddit.com/r/learnjava/comments/wgwowp/how_can_i_improve_this_code/%n%n");
			Thread.sleep(4000);
			System.out.printf("\tEnjoy!%n");
			Thread.sleep(3000);
			System.out.printf("\t\t\t\t\t- Created by Anderson Bassan%n%n%n");
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}

 	private void generateRandomChar() {	
		/*  picks a random char that corresponds to a nato phonetic alphabet word, implemented in a way that feels more random */

		int randomCharIndex = randomGenerator.nextInt(natoPhoneticAlphabet.size());
		Character[] availableWordsSymbols = natoPhoneticAlphabet.keySet().toArray(new Character[natoPhoneticAlphabet.size()]);

		// if the random char is precedes, follows or is the same as the previous random char then generate a new one
		if (2 <= natoPhoneticAlphabet.size() && (previousRandomChar == (char) (availableWordsSymbols[randomCharIndex] - 1) || previousRandomChar == (char) (availableWordsSymbols[randomCharIndex] + 1) || previousRandomChar == (char) (availableWordsSymbols[randomCharIndex]))) {
			generateRandomChar();
			
		} else {
			randomChar = availableWordsSymbols[randomCharIndex];
			previousRandomChar = randomChar;
			
		}
	}
	
	public char getRandomChar() {
		return randomChar;
	}
	
	private String getInput() {
		// get's user input from terminal or return exit in case of timeout
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		InputReader inputReader = new InputReader();
		
		// input run's in a separated thread so it won't block the main thread after timing out
		Future<String> result = executor.submit(inputReader);
		
		try {
			return result.get(INPUT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
			
		} catch(ExecutionException | InterruptedException e) {
			return "exit";
			
		} catch(TimeoutException e) {
			System.out.printf("%n%n%nYou took too long to answer and lost due to time.%n");
			return "exit";
			
		} finally {
			executor.shutdown();
			
		}
	}
	
	private void showPoints() {		
		System.out.println("");
		System.out.println("");
		System.out.println("####################################");
		System.out.println("#                                  #");
		
		if (0 <= points && points < 10) {
			System.out.printf("#    Your current points are %d     #%n", points);
		
		} else if (-10 < points || 10 < points) {
			System.out.printf("#    Your current points are %d    #%n", points);
		
		} else {
			System.out.printf("#    Your current points are %d   #%n", points);
		}

		System.out.println("#                                  #");
		System.out.println("####################################");
		System.out.println("");
		System.out.println("");
	}
	
	private void showFinalPoints() {
		/* shows if you won and your final score */
		
		System.out.println("");
		System.out.println("");
		System.out.println("####################################");
		
		if (natoPhoneticAlphabet.size() == 0) {
			System.out.println("#              YOU WON             #");
			
		} else {
			System.out.println("#             GAME OVER            #");
		}
		
		System.out.println("####################################");
		System.out.println("");
		System.out.println("");		
		System.out.println("####################################");
		System.out.println("#                                  #");

		if (0 <= points && points < 10) {
			System.out.printf("#    You final score was %d         #%n", points);
		
		} else if (-10 < points || 10 < points) {
			System.out.printf("#    You final score was %d        #%n", points);
			
		} else {
			System.out.printf("#    You final score was %d       #%n", points);
		}	

		System.out.println("#                                  #");
		System.out.println("####################################");
	}

	private boolean guess() {
		/* generates a random word, show the first letter to the user and see if they get it right in less than N seconds */
		
		generateRandomChar();
		String correctWord = natoPhoneticAlphabet.get(getRandomChar());
		
		System.out.printf("What is the word for %c (exit to exit): ", getRandomChar());
		String inputWord = getInput();

		if (inputWord.equals("exit")) {
			return false;
		}

		// verify if the input word is close enough to the correct word
		if (lev.fuzzyMatch(inputWord, correctWord, MAXIMUM_ACCEPTED_DISTANCE)) {
			natoPhoneticAlphabet.remove(randomChar, correctWord); // remove word from possible random words
			points++;
			
			// ends the game if theres no words left to guess
			if (natoPhoneticAlphabet.size() == 0) {
				return false;
				
			}
		
		} else {
			System.out.printf("%nThe correct word is %s.%n", correctWord);
			points--;
			
		}

		showPoints();	
		return true; 	
	}
	
	public void play() {
   		showIntro();
  		while (guess());
		showFinalPoints();
		System.exit(0); // Exits the code in case the user takes too long to type and lose, otherwise readLine() will hang
	}
}

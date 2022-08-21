package com.nato;


import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;


public class GuessTheNatoWord {
	// rewrite this into the contructor and move the building logic to the main class

    private int points = 0;
	
	private static NATOPhoneticAlphabet natoPhoneticAlphabet;
	private static RandomCharacterGenerator randomCharacter;
	
	private static final int INPUT_TIMEOUT_SECONDS = 3;
	private static final TimedOutUserInput timedOutUserInput = new TimedOutUserInput(new InputReader(new BufferedReader(new InputStreamReader(System.in))));

	private static final LevenshteinAlgorithm lev = new LevenshteinAlgorithm();
	private static final int MAXIMUM_ACCEPTED_DISTANCE = 2;

 	public GuessTheNatoWord(NATOPhoneticAlphabet natoPhoneticAlphabet, RandomCharacterGenerator randomCharacter) {
		this.natoPhoneticAlphabet = natoPhoneticAlphabet;
		this.randomCharacter = randomCharacter;
	}

	public void showIntro() {
		// show an intro explaining the project
		
		try {
			var bf = new BufferedReader(new InputStreamReader(System.in));

			System.out.printf("%n%n\tWelcome to NATO Phonetic Alphabet%n%n");
			System.out.printf("\tThis is a game to help you learn the NATO Phonetic Alphabet while having fun.%n%n");
			System.out.printf("\tYou have %d seconds to type the word equivalent to the letter shown, otherwise you'll lose.%n", INPUT_TIMEOUT_SECONDS);
			System.out.printf("\tIf you get all words correctly, then you win the game.%n%n");
			System.out.printf("\tThe main idea for this project was taken from Reddit, namely, r/learnJava, but I designed and coded this%n");
			System.out.printf("\tprogram on my own while receiving feedback on my code from the reddit users u/NautiHooker, u/Nightcorex_.%n");
			System.out.printf("\tand u/geoffreychallen.%n%n");
			System.out.printf("\tmy post link: https://www.reddit.com/r/learnjava/comments/wgwowp/how_can_i_improve_this_code/%n%n");
			System.out.printf("\tEnjoy!%n");
			System.out.printf("\t\t\t\t\t- Created by Anderson Bassan%n%n%n");
			System.out.printf("\t\t\t\t\t[PRESS ENTER TO START THE GAME]%n");

			try {
				while (!bf.ready()) {
					Thread.sleep(20);
				}
			
				bf.readLine();
			} catch (IOException e) {
				System.out.println("input error when getting enter to start the game");
				e.printStackTrace();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	
	private String getInput() {
		try {
			return timedOutUserInput.getTimedOutUserInput(INPUT_TIMEOUT_SECONDS, SECONDS, "you ran out of time and lost", "exit");
		} catch (IOException e) {
			return "exit";
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
		
 		if (natoPhoneticAlphabet.getSize() == 0) {
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

 		randomCharacter.generateRandom();
		String correctWord = natoPhoneticAlphabet.getByKey(randomCharacter.getRandom());
		
		System.out.printf("What is the word for %c (exit to exit): ", randomCharacter.getRandom());
		String inputWord = getInput();

		if (inputWord.equals("exit")) {
			return false;
		}

		// verify if the input word is close enough to the correct word
		if (lev.fuzzyMatch(inputWord, correctWord, MAXIMUM_ACCEPTED_DISTANCE)) {
			natoPhoneticAlphabet.removeByKey(randomCharacter.getRandom()); // remove word from possible random words
			points++;
			
			// ends the game if theres no words left to guess
			if (natoPhoneticAlphabet.getSize() == 0) {
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

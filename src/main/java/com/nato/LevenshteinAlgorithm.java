/*
	That's my implementation of the Levenshtein Distance Algorithm; it's not perfect, but it gets the job done.
	
	For reference see:
	https://en.wikipedia.org/wiki/Levenshtein_distance#:~:text=Informally%2C%20the%20Levenshtein%20distance%20between,considered%20this%20distance%20in%201965.
	
	and:
	https://medium.com/@ethannam/understanding-the-levenshtein-distance-equation-for-beginners-c4285a5604f0
*/


package com.nato;


public class LevenshteinAlgorithm {
	public int calculateDistance(String string1, String string2) throws NullPointerException {
		// *tail is the substring that contain all original characters except for the last one
		
		int lev1, lev2, lev3;

		// verify that there's no null paramethers
		if (string1 == null || string2 == null) {
			throw new NullPointerException("calculateDistance paramethers can't be null");
			
		}
		
		if (Math.min(string1.length(), string2.length()) == 0) {
			// "" and "" return zero because they are equal even if they're empty
			/*  if only one string is empty you need to add all chars of the other string, thus the distance is
				the number of chars of the biggest string*/

			return Math.max(string1.length(), string2.length());
			
		}
				
 		if (string1.charAt(string1.length() - 1) == string2.charAt(string2.length() - 1)) {
			// calculate the distance for the *tail of both strings and the distance stays the same
			
			return calculateDistance(string1.substring(0, string1.length() - 1), string2.substring(0, string2.length() - 1));
			
		} else {
			lev1 = calculateDistance(string1.substring(0, string1.length() - 1), string2.substring(0, string2.length() - 1));
			lev2 = calculateDistance(string1.substring(0, string1.length() - 1), string2);
			lev3 = calculateDistance(string1, string2.substring(0, string2.length() - 1));

			//  if the last chars are not equal, at least one will need to be changed
			return 1 + Math.min(Math.min(lev1, lev2), lev3);	

		}
	}

 	public boolean fuzzyMatch(String string1, String string2, int maximumAcceptedDistance) {
 		if (calculateDistance(string1, string2) <= maximumAcceptedDistance) {
			return true;
			
		} else {
			return false;
			
		}

	}
	
	public void testCalculateDistance() {	
		if (calculateDistance("", "") == 0) {
			System.out.println("\ttest two: passed");
			
		} else {
			System.out.println("\ttest two: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("", ""));
			
		}

		if (calculateDistance("t", "t") == 0) {
			System.out.println("\ttest three: passed");
			
		} else {
			System.out.println("\ttest three: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("t", "t"));
			
		}
		
		if (calculateDistance("test", "test") == 0) {
			System.out.println("\ttest four: passed");
			
		} else {
			System.out.println("\ttest four: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("test", "test"));
			
		}
		
		if (calculateDistance("test", "est") == 1) {
			System.out.println("\ttest five: passed");
			
		} else {
			System.out.println("\ttest five: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("test", "est"));
			
		}

		if (calculateDistance("test", "tesd") == 1) {
			System.out.println("\ttest six: passed");
			
		} else {
			System.out.println("\ttest six: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("test", "tesd"));
			
		}

		if (calculateDistance("think", "thing") == 1) {
			System.out.println("\ttest seven: passed");
			
		} else {
			System.out.println("\ttest seven: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("think", "thing"));
			
		}

		if (calculateDistance("pato", "gato") == 1) {
			System.out.println("\ttest eight: passed");
			
		} else {
			System.out.println("\ttest eight: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("pato", "gato"));
			
		}
		
		if (calculateDistance("book", "back") == 2	) {
			System.out.println("\ttest nine: passed");
			
		} else {
			System.out.println("\ttest nine: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("book", "back"));
			
		}
		
		if (calculateDistance("strip", "number") == 6	) {
			System.out.println("\ttest ten: passed");
			
		} else {
			System.out.println("\ttest ten: failed");
			System.out.printf("Expected result: 1%nResult: %s", calculateDistance("strip", "number"));
			
		}
		
		try {
			calculateDistance("strip", null);
			
		} catch (NullPointerException e) {
			System.out.println("\ttest eleven: passed");
			
		}

		try {
			calculateDistance(null, "number");
			
		} catch (NullPointerException e) {
			System.out.println("\ttest twelve: passed");
			
		}

		try {
			calculateDistance(null, null);
			
		} catch (NullPointerException e) {
			System.out.println("\ttest thirteen: passed");
			
		}

	}
	
	public void test() {
		System.out.printf("%n%nCALCULATE DISTANCE TESTS%n");
		testCalculateDistance();
		
	}
}
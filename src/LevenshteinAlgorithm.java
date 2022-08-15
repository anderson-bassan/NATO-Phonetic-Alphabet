public class LevenshteinAlgorithm {
	public int calculateDistance(String stringOne, String stringTwo) {
		if (Math.min(stringOne.length(), stringTwo.length()) == 0) {
			return Math.max(stringOne.length(), stringTwo.length());
		}

/* 		if (stringOne.charAt(0) == stringTwo.charAt(0)) {
			System.out.println(calculateDistance(stringOne.substring(0, stringOne.length() - 1), stringTwo.substring(0, stringTwo.length() - 1)));
			return 0;
		} */
 		if (stringOne.charAt(stringOne.length() - 1) == stringTwo.charAt(stringTwo.length() - 1)) {
			// remove last chars from both strings and return a new calculateDistance call
			return calculateDistance(stringOne.substring(0, stringOne.length() - 1), stringTwo.substring(0, stringTwo.length() - 1));
			
		} else {
			// if characters are different then add one to distance
			return (calculateDistance(stringOne.substring(0, stringOne.length() - 1), stringTwo.substring(0, stringTwo.length() - 1)) + 1);
		} 		
	}

/* 	public boolean fuzzyMatching(String stringOne, String stringTwo, int maximumAcceptedDistance) {
 		if (calculateDistance(stringOne, stringTwo) <= maximumAcceptedDistance) {
			return true;
		} else {
			return false;
		}

	} */
	
	public void test() {
		System.out.printf("%n%nCALCULATE DISTANCE TESTS%n");
		testCalculateDistance();
	}
	
	public void testCalculateDistance() {
		if (calculateDistance("gato", "") == 4) {
			System.out.println("\ttest one: passed");
		} else {
			System.out.println("zttest one: failed");
		}
		
		if (calculateDistance("", "") == 0) {
			System.out.println("\ttest two: passed");
		} else {
			System.out.println("\ttest two: failed");
		}

		if (calculateDistance("t", "t") == 0) {
			System.out.println("\ttest three: passed");
		} else {
			System.out.println("\ttest three: failed");
		}
		
		if (calculateDistance("test", "test") == 0) {
			System.out.println("\ttest four: passed");
		} else {
			System.out.println("\ttest four: failed");
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
	}
}
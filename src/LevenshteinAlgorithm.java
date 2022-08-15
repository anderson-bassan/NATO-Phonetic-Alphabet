public class LevenshteinAlgorithm {
	public int calculateDistance(String stringOne, String stringTwo) {
		if (Math.min(stringOne.length(), stringTwo.length()) == 0) {
			return Math.max(stringOne.length(), stringTwo.length());
		}
		
		return 0;
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
	}
}
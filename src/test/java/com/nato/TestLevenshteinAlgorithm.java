package com.nato;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestLevenshteinAlgorithm {
	@Test
	@DisplayName("gato and nothing should be equal to four")
	void gatoAndNothingShouldBeEqualToFour() {
		var lev = new LevenshteinAlgorithm();
		assertEquals(4, lev.calculateDistance("gato", ""));
	}
	
	@Test
	@DisplayName("nohting and nothing should be equal to zero")
	void nothingAndNothingShouldBeEqualToZero() {
		var lev = new LevenshteinAlgorithm();
		assertEquals(0, lev.calculateDistance("", ""));		
	}

	@Test
	@DisplayName("nohting and nothing should be equal to zero")
	void nothingAndNothingShouldBeEqualToZero() {
		var lev = new LevenshteinAlgorithm();
		assertEquals(0, lev.calculateDistance("", ""));		
	}
}
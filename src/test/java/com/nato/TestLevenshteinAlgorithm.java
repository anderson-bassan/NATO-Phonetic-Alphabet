package com.nato;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TestLevenshteinAlgorithm {
	
	@Test
	@DisplayName("assert that calculate distance is working properly")
	void assertThatCalculateDistanceIsWorkingProperly() {
		var lev = new LevenshteinAlgorithm();

		assertAll("calculateDistance",
			() -> assertEquals(4, lev.calculateDistance("gato", ""), "\"\" and gat should be equal to 0"),
			() -> assertEquals(0, lev.calculateDistance("", ""), "\"\" and \"\" should be equal to 0"),
			() -> assertEquals(0, lev.calculateDistance("t", "t"), "t and t should be equal to 0"),
			() -> assertEquals(0, lev.calculateDistance("test", "test"), "test and test should be equal to 0"),
			() -> assertEquals(1, lev.calculateDistance("test", "est"), "test and est should be equal to 1"),
			() -> assertEquals(1, lev.calculateDistance("test", "tesd"), "test and tesd should be equal to 1"),
			() -> assertEquals(1, lev.calculateDistance("test", "testd"), "test and testd should be equal to 1"),
			() -> assertEquals(1, lev.calculateDistance("thing", "think"), "test and tesd should be equal to 1"),
			() -> assertEquals(1, lev.calculateDistance("test", "tesd"), "test and tesd should be equal to 1"),
			() -> assertEquals(1, lev.calculateDistance("pato", "gato"), "pato and gato should be equal to 1"),
			() -> assertEquals(2, lev.calculateDistance("back", "book"), "pato and gato should be equal to 2"),
			() -> assertEquals(6, lev.calculateDistance("strip", "number"), "strip and number should be equal to 6"),
			() -> assertThrows(NullPointerException.class, () -> lev.calculateDistance("strip", null), "strip and null should throw NullPointerException"),
			() -> assertThrows(NullPointerException.class, () -> lev.calculateDistance(null, "number"), "null and number should throw NullPointerException"),
			() -> assertThrows(NullPointerException.class, () -> lev.calculateDistance(null, null), "null and null should throw NullPointerException")
		);
	}
}
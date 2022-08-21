package com.nato;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPoints {
	Points points;

	@BeforeEach
	void setup() {
		this.points = new Points("your current points are", "you finished with a score of", "you own", "game over", "you lost by timeout");
	}

	@Test
	@DisplayName("test get points")
	void testGetPoints() {
		assertEquals(0, points.getPoints(), "get points should be zero when the obj is instanciated.");
	}
	
	@Test
	@DisplayName("test increase points")
	void testIncreasePoints() {
		points.increasePoints();
		assertEquals(1, points.getPoints(), "after increase points get points should return 1.");
		
		points.increasePoints();
		assertEquals(2, points.getPoints(), "after increase points get points should return 2.");
	}
	
	@Test
	@DisplayName("test decrease points")
	void testDecreasePoints() {
		points.decreasePoints();
		assertEquals(-1, points.getPoints(), "after decrease points get points should return -1.");
		
 		points.decreasePoints();
		assertEquals(-2, points.getPoints(), "after decrease points get points should return -2.");
		
		// increase points untill it reaches positive two
		for (int i = 0; i < 4; i++) {
			points.increasePoints();
		}

		// test if decrease works properly with positive numbers
		points.decreasePoints();
		assertEquals(1, points.getPoints(), "after decrease points get points should return 1.");
	}
	
/*   	@Test
	void testShowCurrentPoints() {
		int i = 0;

		while(i < 9) {
			points.increasePoints();
			i++;
		}

		points.showCurrentPoints();
	
		while(i < 11) {
			points.increasePoints();
			i++;
		}

		points.showCurrentPoints();
		
		while(i > -9) {
			points.decreasePoints();
			i--;
		}

		points.showCurrentPoints();
		
		while(i > -15) {
			points.decreasePoints();
			i--;
		}

		points.showCurrentPoints();
	}
	
 	@Test
	void testShowFinalPoints() {
		int i = 0;

		while(i < 9) {
			points.increasePoints();
			i++;
		}

		points.showFinalPoints();
	
		while(i < 11) {
			points.increasePoints();
			i++;
		}

		points.showFinalPoints();
		
		while(i > -9) {
			points.decreasePoints();
			i--;
		}

		points.showFinalPoints();
		
		while(i > -15) {
			points.decreasePoints();
			i--;
		}

		points.showFinalPoints();
	}
	
	@Test
	void testWinMessage() {
		points.showWinMessage();
	}
	
	@Test
	void testGameOverMessage() {
		points.showGameOverMessage();
	}
	
	@Test
	void testGameOverByTimeoutMessage() {
		points.showGameOverByTimeOutMessage();
	}*/
}
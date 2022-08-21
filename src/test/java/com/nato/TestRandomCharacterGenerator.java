package com.nato;

import java.util.Random;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class TestRandomCharacterGenerator {
	@Mock
	NATOPhoneticAlphabet natoMock;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("test get random with only 1 char")
	void testGetRandomWithOnlyA() {
 		Character[] mockKeys = {'a'};

  		when(natoMock.getSize()).thenReturn(1);
   		when(natoMock.getKeys()).thenReturn(mockKeys);

		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), natoMock);
 		assertEquals('`', randomCharacterGenerator.getRandom(), "get random should equal `");
		
		randomCharacterGenerator.generateRandom();
		assertEquals('a', randomCharacterGenerator.getRandom(), "get random should equal a");
	}

	@Test
	@DisplayName("test get random with only 2 chars")
	void testGetRandomWithOnlyAAndB() {
 		Character[] mockKeys = {'a', 'b'};

  		when(natoMock.getSize()).thenReturn(2);
   		when(natoMock.getKeys()).thenReturn(mockKeys);

		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), natoMock);
		
		randomCharacterGenerator.generateRandom();
		assertThat("get random with a or b should be equal to a or b", Arrays.asList('a', 'b'), hasItem(randomCharacterGenerator.getRandom()));
	}
	
	@Test
	@DisplayName("test get random with all chars")
	void testGetRandomWithRealNATOPhoneticAlphabet() {
		var randomCharacterGenerator = new RandomCharacterGenerator(new Random(), new NATOPhoneticAlphabet());
		Character[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

		randomCharacterGenerator.generateRandom();
		assertThat("get random with real object should be within 0-9a-z", Arrays.asList(alphabet), hasItem(randomCharacterGenerator.getRandom()));
	}
}
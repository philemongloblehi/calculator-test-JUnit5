package com.openclassrooms.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private static Instant startedAt;
	private Calculator calculatorUnderTest;
	
	@BeforeEach
	public void initCalculator() {
		System.out.println("Appel avant chaque test");
		this.calculatorUnderTest = new Calculator();
	}
	
	@AfterEach
	public void undefCalculator() {
		System.out.println("Appel après chaque test");
		calculatorUnderTest = null;
	}
	
	@BeforeAll
	public static void initStartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();
	}
	
	@AfterAll
	public static void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

	@Test
	void testAddTwoPositiveNumbers() {
		// Arrange
		int a = 2;
		int b = 3;
		
		// Act
		int somme = calculatorUnderTest.add(a, b);
		
		// Assert
		// assertEquals(5, somme);
		assertThat(somme).isEqualTo(5);
	}
	
	@Test
	void multiply_shouldReturnTheProduct_ofTwoInteger() {
		// Arrange
		int a = 42;
		int b= 11;
		
		// Act
		int produit = calculatorUnderTest.multiply(a, b);
		
		// Assert
		// assertEquals(462, produit);
		assertThat(produit).isEqualTo(462);
	}
	
//	@Test
//	public void listDigits_shouldReturnsTheListOfDigits_ofPositiveInteger() {
//		// GIVEN
//		int number = 95897;
//		
//		// WHEN
//		final Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
//		
//		// THEN
//		final Set<Integer> expectedDigits = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
//		assertEquals(expectedDigits, actualDigits);
//	}

}

package com.cognizant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorAAATest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup completed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Teardown completed");
    }

    @Test
    void testMultiply() {

        // Arrange
        int a = 5;
        int b = 4;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }
}

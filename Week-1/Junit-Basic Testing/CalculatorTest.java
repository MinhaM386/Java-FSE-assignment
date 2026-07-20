package com.cognizant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {

        Calculator calculator = new Calculator();

        int result = calculator.add(5, 3);

        assertEquals(8, result);
    }

}


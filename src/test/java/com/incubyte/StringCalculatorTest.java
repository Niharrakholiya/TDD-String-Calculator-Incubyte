package com.incubyte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringCalculatorTest {
    @Test
    void returnsZeroWhenInputIsEmpty() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
   void nullReturnsZero() {
        assertEquals(0, StringCalculator.add(null));
    }

    @Test
    void singleNumberReturnsValue() {
        assertEquals(7, StringCalculator.add("7"));
    }
}

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
        assertEquals(40, StringCalculator.add("40"));
    }

    @Test
    void twoNumbersCommaDelimited() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    void newlinesAndCommas() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

}

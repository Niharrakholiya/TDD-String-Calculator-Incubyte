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

    @Test
    void negativeNumberThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> StringCalculator.add("1,-2,3"));
    }

    @Test
    void multipleNegativesThrowsExceptionWithAllNegativesListed() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> StringCalculator.add("-1,2,-3"));

        assertTrue(exception.getMessage().contains("-1"));
        assertTrue(exception.getMessage().contains("-3"));
    }

    @Test
    void customSingleCharDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    void customMultiCharDelimiter() {
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    void numbersGreaterThan1000AreIgnored() {
        assertEquals(2, StringCalculator.add("2,1001"));
        assertEquals(1002, StringCalculator.add("2,1000"));
    }

    @Test
    void multipleSingleCharDelimiters() {
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    void multipleMultiCharDelimiters() {
        assertEquals(9, StringCalculator.add("//[***][%%%]\n1***2%%%3***3"));
    }

    @Test
    void delimiterWithSpecialCharacters() {
        assertEquals(6, StringCalculator.add("//[$^][123]\n1$^2" + "123" + "3"));
    }

    @Test
    void nonNumericTokensShouldBeIgnored() {
        assertEquals(4, StringCalculator.add("1,X,3"));
    }



}

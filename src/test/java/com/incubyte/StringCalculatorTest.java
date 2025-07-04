package com.incubyte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringCalculatorTest {
    @Test
    void returnsZeroWhenInputIsEmpty() {
        assertEquals(0, StringCalculator.add(""));
    }

}

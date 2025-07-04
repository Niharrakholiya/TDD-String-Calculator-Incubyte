package com.incubyte;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        String[] tokens = input.split(",|\\n");
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            int number = parseInt(token);
            if (number < 0) {
                negatives.add(number);
            }
            sum += number;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives.get(0));
        }

        return sum;
    }
}

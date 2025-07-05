package com.incubyte;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class StringCalculator {

    private static void checkNegatives(List<Integer> negatives) {
        if (!negatives.isEmpty()) {
            String message = "negatives not allowed: " + String.join(", ",
                    negatives.stream().map(String::valueOf).toList());
            throw new IllegalArgumentException(message);
        }
    }

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

        checkNegatives(negatives);

        return sum;
    }
}

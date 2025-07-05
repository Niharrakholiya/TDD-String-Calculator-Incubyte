package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;


public class StringCalculator {

    private static void checkNegatives(List<Integer> negatives) {
        if (!negatives.isEmpty()) {
            String message = "negatives not allowed: " + String.join(", ",
                    negatives.stream().map(String::valueOf).toList());
            throw new IllegalArgumentException(message);
        }
    }

    private static String getDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\n");
            String delimiterSection = input.substring(2, delimiterEnd);

            // Case: multi-char delimiter like //[***]
            if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
                return Pattern.quote(delimiterSection.substring(1, delimiterSection.length() - 1));
            }

            // Case: single-char delimiter
            return Pattern.quote(delimiterSection);
        }
        return ",|\n";
    }

    private static String[] splitInput(String input, String delimiter) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf("\n") + 1);
        }
        return input.split(delimiter);
    }
    private static int parseAndSum(String[] tokens) {
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            Integer number = parseToken(token);
            if (number == null) continue;

            if (number < 0) {
                negatives.add(number);
            } else if (number <= 1000) {
                sum += number;
            }
        }

        checkNegatives(negatives);
        return sum;
    }

    private static Integer parseToken(String token) {
        if (token == null || token.isEmpty()) return null;
        try {
            return parseInt(token.trim());
        } catch (NumberFormatException e) {
            return null; // safely ignore malformed tokens if any
        }
    }



    public static int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        String delimiter = getDelimiter(input);
        String[] tokens= splitInput(input, delimiter);

        List<Integer> negatives = new ArrayList<>();
        int sum = parseAndSum(tokens);

        checkNegatives(negatives);

        return sum;
    }
}

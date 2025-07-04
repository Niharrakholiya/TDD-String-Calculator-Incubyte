package com.incubyte;


import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        String[] tokens = input.split(",|\\n");
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                sum += parseInt(token);
            }
        }
        return sum;
    }
}

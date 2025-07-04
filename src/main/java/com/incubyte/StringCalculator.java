package com.incubyte;


import static java.lang.Integer.parseInt;

public class StringCalculator {
        public static int add(String input) {
            if(input == null || input.isEmpty()) return 0;

            if (!input.contains(",") && !input.contains("\n")) {
                return Integer.parseInt(input);
            }
            return 0;
        }
}

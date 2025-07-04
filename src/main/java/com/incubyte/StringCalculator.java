package com.incubyte;


import static java.lang.Integer.parseInt;

public class StringCalculator {
        public static int add(String input) {
            if(input == null || input.isEmpty()) return 0;

            if (!input.contains(",") && !input.contains("\n")) {
                return Integer.parseInt(input);
            }
            String[] tokens = input.split(",|\\n");

            int sum = 0;
            for (String t : tokens) {
                if (!t.isEmpty()) {
                    sum += Integer.parseInt(t);
                }
            }
            return sum;

        }
}

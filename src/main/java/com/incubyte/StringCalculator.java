package com.incubyte;


import static java.lang.Integer.parseInt;

public class StringCalculator {
        public static int add(String input) {
            if(input == null || input.isEmpty()) return 0;

            if (!input.contains(",") && !input.contains("\n")) {
                return Integer.parseInt(input);
            }
            else if (input.contains(",")) {
                String[] nums = input.split(",");
                return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
            }

            return 0;
        }
}

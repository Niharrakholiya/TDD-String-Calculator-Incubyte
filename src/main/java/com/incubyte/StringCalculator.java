package com.incubyte;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) return 0;

        int sum =0;
        String[] tokens = input.split(",|\\n");
        List<Integer> negatives = new ArrayList<>();

        for (String t : tokens) {
            int n = Integer.parseInt(t);
            if (n < 0) {
                negatives.add(n);
            }
            sum += n;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives.get(0));
        }
        return sum;
    }
}

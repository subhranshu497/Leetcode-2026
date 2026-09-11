package com.com.leetcode.sept;

import java.util.HashSet;
import java.util.Set;

public class UniqueThreeDigitEvenNumbers {
    public static void main(String[] args) {
        int [] digits = {1,2,3,4};
        int count = totalNumbers(digits);
        System.out.println(count);
    }

    private static int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && i != k && j != k) {
                        if (digits[i] != 0) {
                            if (digits[k] % 2 == 0) {
                                int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                                set.add(number);
                            }
                        }
                    }
                }
            }
        }
        return set.size();
    }
}

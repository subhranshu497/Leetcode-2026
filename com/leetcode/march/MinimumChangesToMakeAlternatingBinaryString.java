package com.com.leetcode.march;

public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        String s = "1111";
        int count = minOperations(s);
        System.out.println(count);
    }

    private static int minOperations(String s) {
        int n = s.length();
        int countPattern1 = 0;
        int countPattern2 = 0;

        for (int i = 0; i < n; i++) {
            char expectedCharPattern1 = (i % 2 == 0) ? '0' : '1';
            char expectedCharPattern2 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expectedCharPattern1) {
                countPattern1++;
            }
            if (s.charAt(i) != expectedCharPattern2) {
                countPattern2++;
            }
        }
        return Math.min(countPattern1, countPattern2);
    }
}

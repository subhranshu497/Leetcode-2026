package com.com.leetcode.march;

public class CheckifStringsCanbeMadeEqualWithOperationsII {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        boolean flag = checkStrings(s1, s2);
        System.out.println(flag);
    }
    public static boolean checkStrings(String s1, String s2) {
        int[] freq = new int[52];

        for (int i = 0; i < s1.length(); i++) {
            int off = (i & 1) * 26;
            freq[s1.charAt(i) - 'a' + off]++;
            freq[s2.charAt(i) - 'a' + off]--;
        }

        for (int i = 0; i < 52; i++)
            if (freq[i] != 0) return false;

        return true;
    }
}

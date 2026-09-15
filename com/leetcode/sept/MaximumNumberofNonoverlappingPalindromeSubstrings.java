package com.com.leetcode.sept;

public class MaximumNumberofNonoverlappingPalindromeSubstrings {
    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;
        int res = maxPalindromes(s,k);
        System.out.println(res);
    }

    private static int maxPalindromes(String s, int k) {
        int count = 0;
        int n = s.length();
        int i = 0;

        while (i <= n - k) {
            // Check if there's a palindrome of length k starting at i
            if (isPalindrome(s, i, i + k - 1)) {
                count++;
                i += k; // Jump past the palindrome
            }
            // Check if there's a palindrome of length k + 1 starting at i
            else if (i + k < n && isPalindrome(s, i, i + k)) {
                count++;
                i += k + 1; // Jump past the palindrome
            }
            else {
                i++; // Advance by 1 if no palindrome found starting at i
            }
        }

        return count;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

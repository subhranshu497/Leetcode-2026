package com.com.leetcode.sept;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        int res = numDistinct(s,t);
        System.out.println(res);
    }

    private static int numDistinct(String s, String t) {
        int m = t.length();

        long[] dp = new long[m + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = m; j >= 1; j--) {
                if (c == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return (int) dp[m];
    }
}

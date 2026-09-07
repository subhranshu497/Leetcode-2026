package com.com.leetcode.sept;

public class DistinctSubsequencesII {
    public static void main(String[] args) {
        String s = "abc";
        int res = distinctSubseqII(s);
        System.out.println(res);
    }
    public static int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = 1000000007;

        long[] last = new long[26];

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[c] != 0) {
                dp[i] = (dp[i] - last[c] + MOD) % MOD;
            }

            last[c] = dp[i - 1] % MOD;
        }

        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}

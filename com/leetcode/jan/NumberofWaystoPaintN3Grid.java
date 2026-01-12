package com.com.leetcode.jan;

public class NumberofWaystoPaintN3Grid {
    public static void main(String[] args) {
        int n =3;
        int res = numOfWays(n);
        System.out.println(res);
    }

    public static int numOfWays(int n) {
        final int MOD = 1000000007;
        long x = 6, y = 6;

        for (int i = 2; i <= n; i++) {
            long new_x = (3 * x + 2 * y) % MOD;
            long new_y = (2 * x + 2 * y) % MOD;
            x = new_x;
            y = new_y;
        }

        return (int)((x + y) % MOD);
    }
}

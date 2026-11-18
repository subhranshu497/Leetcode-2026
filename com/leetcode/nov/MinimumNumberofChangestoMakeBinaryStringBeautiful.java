package com.com.leetcode.nov;

import com.com.leetcode.sept.MaximumNestingDepthoftheParentheses;

public class MinimumNumberofChangestoMakeBinaryStringBeautiful {
    public static void main(String[] args) {
        String s = "1001";
        int res = minChanges(s);
        System.out.println(res);
    }

    private static int minChanges(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                ans++;
            }
        }
        return ans;
    }
}

package com.com.leetcode.march;

import java.util.HashMap;
import java.util.Map;

public class CheckifStringsCanbeMadeEqualWithOperationsI {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        boolean flag = canBeEqual(s1, s2);
        System.out.println(flag);
    }

    private static boolean canBeEqual(String s1, String s2) {
        return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0))) &&
                ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                        (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));
    }
}

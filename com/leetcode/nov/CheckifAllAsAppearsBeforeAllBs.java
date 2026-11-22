package com.com.leetcode.nov;

public class CheckifAllAsAppearsBeforeAllBs {
    public static void main(String[] args) {
        String s ="aaabbb";
        boolean flag = checkString(s);
        System.out.println(flag);
    }

    private static boolean checkString(String s) {
        return !s.contains("ba");
        }
}

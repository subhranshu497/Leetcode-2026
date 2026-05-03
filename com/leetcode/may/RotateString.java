package com.com.leetcode.may;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        boolean res = rotateString(s, goal);
        System.out.println(res);
    }

    private static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String ss = s + s;
        return ss.contains(goal);
    }
}

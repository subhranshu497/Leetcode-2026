package com.com.leetcode.may;

import java.util.Arrays;

public class JumpGameVII {
    private static boolean [] memo;
    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        boolean canReach = canReachI(s, minJump, maxJump);
        System.out.println(canReach);
    }

    private static boolean canReachI(String s, int minJump, int maxJump) {
        memo = new boolean[s.length()];
        return canReachHelper(s, minJump, maxJump, 0);
    }

    private static boolean canReachHelper(String s, int minJump, int maxJump, int i) {
        //base case
        if(i>=s.length() || s.charAt(i) == '1') return false;
        if(i==s.length()-1) return true;
        if(memo[i] != false) return memo[i] == true;
        //start the recursion
        for(int jump = minJump; jump<=maxJump;jump++){
            if(i+jump <s.length() && s.charAt(i+jump)=='0'){
                if(canReachHelper(s, minJump, maxJump, i+jump)) return memo[i+jump]=true;
            }
        }
        return false;
    }
}

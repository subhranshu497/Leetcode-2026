package com.com.leetcode.feb;

public class countBinarySubstrings {
    public static void main(String[] args) {
        String s = "00110011";
        int res = new countBinarySubstrings().countBinarySubstring(s);
        System.out.println(res);
    }

    public int countBinarySubstring(String s) {
        int n = s.length();
        int i =1;
        int prev =0;
        int curr = 1;
        int res = 0;
        while(i<n){
            if(s.charAt(i)==s.charAt(i-1))curr++;
            else{
                res +=Math.min(prev, curr);
                prev = curr;
                curr =1;
            }
            i++;
        }
        res +=Math.min(prev, curr);
        return res;
    }
}

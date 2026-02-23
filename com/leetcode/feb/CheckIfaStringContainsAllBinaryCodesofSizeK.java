package com.com.leetcode.feb;

import java.util.HashSet;
import java.util.Set;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {
    public static void main(String[] args) {
        String s = "0110";
        int k = 2;
        System.out.println(hasAllCodes(s, k));
    }

    private static boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int size = 1<<k; //2^k
        Set<String> set = new HashSet<>();
        for(int i=0;i<=n-k;i++){
            String sub = s.substring(i,i+k);
            set.add(sub);
            if(set.size() == size){
                return true;
            }
        }
        return false;
    }
}

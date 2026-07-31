package com.com.leetcode.july;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofPushestoTypeWordI {
    public static void main(String[] args) {
        String word = "abcde";
        int len = minimumPushes(word);
        System.out.println(len);
    }

    private static int minimumPushes(String word) {
        Map<Integer, Integer> map = new HashMap<>();
        int res =0;
        int assign_key=2;
        for(char c:word.toCharArray()){
            if(assign_key > 9) assign_key = 2;
            map.put(assign_key ,map.getOrDefault(assign_key,0)+1);
            res +=map.get(assign_key);
            assign_key++;
        }
        return res;
    }

//    private static int minimumPushes(String word) {
//        int n = word.length();
//        int mod = n%8;
//        int ans =0;
//        int res = n/8;
//        int i=1;
//        for(;i<=res;i++){
//            int prod = i*8;
//            ans +=prod;
//        }
//        int fprod = i*mod;
//        ans +=fprod;
//        return ans;
//    }
}

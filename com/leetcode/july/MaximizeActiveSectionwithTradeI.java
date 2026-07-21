package com.com.leetcode.july;

import java.util.Map;

public class MaximizeActiveSectionwithTradeI {
    public static void main(String[] args) {
        String s = "0100"; // 101001
        int res = maxActiveSectionsAfterTrade(s);
        System.out.println(res);
    }

    private static int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        char [] arr = s.toCharArray();
        int countOne =0;
        int block1 =0;
        int block2 =0;
        int i=0;
        int max = 0;
        while(i<n){
            char ch = arr[i];
            if(ch=='0'){
                block1++;
                i++;
            }
            else{
                while(i<n && arr[i]=='1'){
                    countOne++;
                    i++;
                    if(i !=n)ch = arr[i];
                }
                while(i<n && arr[i]=='0'){
                    block2++;
                    i++;
                    if(i !=n)ch = arr[i];
                }
                if(block1 !=0 && block2 !=0)
                    max = Math.max(max, block1 + block2);
                block1 = block2;
                block2 = 0;
            }
        }
        return countOne+max;
    }
}

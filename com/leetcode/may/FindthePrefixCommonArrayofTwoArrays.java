package com.com.leetcode.may;

import java.util.HashMap;
import java.util.Map;

public class FindthePrefixCommonArrayofTwoArrays {
    public static void main(String[] args) {
        int [] A = {1,3,2,4};
        int [] B = {3,1,2,4};
        int [] common = findThePrefixCommonArray(A, B);
        for(int i:common){
            System.out.print(i+" ");
        }
    }

    private static int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        int [] c = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        if(a[0]==b[0]){
            c[0] = 1;
            map.put(a[0],1);
        }else{
            map.put(a[0], map.getOrDefault(a[0],0)+1);
            map.put(b[0], map.getOrDefault(b[0],0)+1);
        }

        for(int i=1;i<n;i++){
            int temp = c[i-1];
            if(map.containsKey(b[i])) {
                temp = temp + map.get(b[i]);
            }
            map.put(b[i], map.getOrDefault(b[i],0)+1);
            if(map.containsKey(a[i])){
                temp = temp+ map.get(a[i]);
            }
            c[i] = temp;
            map.put(a[i], map.getOrDefault(a[i],0)+1);

        }
        return c;
    }
}

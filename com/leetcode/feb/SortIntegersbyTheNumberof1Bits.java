package com.com.leetcode.feb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortIntegersbyTheNumberof1Bits {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] res = sortByBits(arr);
        for(int num : res){
            System.out.print(num+" ");
        }
    }

    private static int[] sortByBits(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int [] res = new int[n];
        for(int num : arr){
            int count = findSetBitCount(num);
            map.computeIfAbsent(count, k -> new java.util.ArrayList<>()).add(num);
        }
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> e:map.entrySet()){
            List<Integer> list = e.getValue();
            list.sort(Integer::compareTo);
            for(int num : list){
                res[index++] = num;
            }
        }
        return res;
    }

    private static int findSetBitCount(int num) {
        int count =0;
        while (num>0){
            num = num & (num-1);
            count++;
        }
        return count;
    }


}

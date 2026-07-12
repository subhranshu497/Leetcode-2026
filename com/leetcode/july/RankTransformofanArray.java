package com.com.leetcode.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RankTransformofanArray {
    public static void main(String[] args) {
        int [] arr = {100,100,100};
        int [] res = arrayRankTransform(arr);
        for(int r:res){
            System.out.println(r);
        }
    }

    private static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> rankMap = new HashMap<>();
        //copy the array and sort in desending order
        int [] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);
        int rank =1;
        for (int i=0;i<n;i++) {
            if(!rankMap.containsKey(sortedArr[i]))
                rankMap.put(sortedArr[i], rank++);
        }
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            int val = rankMap.get(arr[i]);
            res[i] = val;
        }
        return res;
    }
}

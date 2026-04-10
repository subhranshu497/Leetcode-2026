package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsI {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 1};
        int result = minDistanceI(arr);
        System.out.println(result); // Output the result
    }

    private static int minDistanceI(int[] arr) {
        int n = arr.length;
        int minDist = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            indexMap.computeIfAbsent(arr[i], k->new ArrayList<>()).add(i);
        }
        //iterate map
        for(Map.Entry<Integer,List<Integer>> entry : indexMap.entrySet())
        {
            List<Integer> indices = entry.getValue();
            if(indices.size()>=3)
            {
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int first = indices.get(i);
                    int third = indices.get(i + 2);
                    int currentDist = 2 * (third - first);
                    minDist = Math.min(minDist, currentDist);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}

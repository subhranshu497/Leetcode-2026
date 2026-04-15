package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistancetoTargetStringinaCircularArray {
    public static void main(String[] args) {
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        int result = closetTarget(words, target, startIndex);
        System.out.println(result); // Output the result
    }

    private static int closetTarget(String[] words, String target, int startIndex) {
        int minDist = Integer.MAX_VALUE;
        Map<String, List<Integer>> indexMap = new HashMap<>();
        for(int i=0;i<words.length;i++)
            indexMap.computeIfAbsent(words[i], k->new ArrayList<>()).add(i);
        if(!indexMap.containsKey(target)) return -1;
        List<Integer> targetIndices = indexMap.get(target);
        for(int index : targetIndices){
            int dist = Math.abs(index - startIndex);
            minDist = Math.min(minDist, Math.min(dist, words.length - dist));
        }
        return minDist;
    }
}

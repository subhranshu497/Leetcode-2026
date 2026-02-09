package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.*;

public class UniqueNumberofOccurrences {
    public static void main(String[] args) {
        int [] nums = {1,2,2,1,1,3};
        boolean flag = uniqueOccurrences(nums);
        System.out.println(flag);
    }

    private static boolean uniqueOccurrences(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums)
            map.put(num, map.getOrDefault(num,0)+1);
        Set<Integer> set = new HashSet<>(map.values());
        return set.size()==map.size();
    }
}

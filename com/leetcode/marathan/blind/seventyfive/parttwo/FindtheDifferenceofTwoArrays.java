package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.*;

public class FindtheDifferenceofTwoArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,3};
        int [] nums2 = {1,1,2,2};
        List<List<Integer>> res =findDifference(nums1, nums2);
        System.out.println(res);
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> tempSet = new HashSet<>();
        for(int num:nums1)
            set1.add(num);
        for(int num:nums2)
            set2.add(num);
        for(int i =0;i<nums2.length;i++){
            if(!set1.contains(nums2[i])){
                tempSet.add(nums2[i]);
            }
        }
        List<Integer> l2 = new ArrayList<>(tempSet);
        tempSet.clear();
        for(int i =0;i<nums1.length;i++){
            if(!set2.contains(nums1[i])){
                tempSet.add(nums1[i]);
            }
        }
        List<Integer> l1 = new ArrayList<>(tempSet);
        return List.of(l1,l2);
    }
}

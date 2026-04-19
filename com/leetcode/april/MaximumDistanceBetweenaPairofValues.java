package com.com.leetcode.april;

public class MaximumDistanceBetweenaPairofValues {
    public static void main(String[] args) {
        int [] nums2 = {25,25,25,25,25}, nums1 = {30,29,19,5};
        int res = maxDistance(nums1, nums2);
        System.out.println(res); // Output the result
    }

    private static int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i=0, j=0;
        int maxDist = 0;
        while(i<n1 && j<n2){
            while(j<n2 && i<=j && nums1[i]<=nums2[j]){
                maxDist = Math.max(maxDist, j-i);
                j++;
            }
            if(i<=j)i++;
            else j++;
        }
        return maxDist;
    }
}

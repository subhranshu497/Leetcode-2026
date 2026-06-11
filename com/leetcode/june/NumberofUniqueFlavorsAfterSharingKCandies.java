package com.leetcode.june;

import java.util.Map;

public class NumberofUniqueFlavorsAfterSharingKCandies {
    public static void main(String[] args) {
        int [] candies = {1,2,2,3,4,3};
        int k = 3;
        int result = distributeCandies(candies, k);
        System.out.println(result);
    }

    private static int distributeCandies(int[] candies, int k) {
        int n = candies.length;
        Map<Integer, Integer> flavorCount = new java.util.HashMap<>();
        for(int candy : candies) {
            flavorCount.put(candy, flavorCount.getOrDefault(candy, 0) + 1);
        }
        int l =0;
        int r = 0;
        int uniques = Integer.MIN_VALUE;
        while(r<n){
            int flavor = candies[r];
            flavorCount.put(flavor, flavorCount.get(flavor) - 1);
            if(flavorCount.get(flavor) == 0){
                flavorCount.remove(flavor);
            }
            if(r-l+1 > k){
                flavorCount.put(candies[l], flavorCount.getOrDefault(candies[l], 0) + 1);
                l++;
            }
            if(r-l+1 == k){
                uniques = Math.max(uniques, flavorCount.size());
            }
            r++;
        }
        int mapSize = flavorCount.size();
        uniques = Math.max(uniques, mapSize);
        return uniques;
    }
}

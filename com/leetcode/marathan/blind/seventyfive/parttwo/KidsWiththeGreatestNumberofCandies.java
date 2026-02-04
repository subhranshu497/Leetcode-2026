package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {
    public static void main(String[] args) {
        int [] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> res = kidsWithCandies(candies, extraCandies);
        for(boolean r:res)
            System.out.print(r+", ");
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for(int candy:candies)
            maxCandies = Math.max(maxCandies, candy);
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean flag = candies[i]+extraCandies >=maxCandies;
            res.add(flag);
        }
        return res;
    }
}

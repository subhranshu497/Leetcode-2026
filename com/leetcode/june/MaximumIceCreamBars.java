package com.com.leetcode.june;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        int [] costs = {1,3,2,4,1};
        int coins = 7;
        int res = maxIceCream(costs, coins);
        System.out.println(res);
    }

    private static int maxIceCream(int[] costs, int coins) {
        //sort the costs array and keep on buying the ice cream until we have coins
        Arrays.sort(costs);
        int res =0;
        for(int cost:costs){
            if(cost<=coins){
                res++;
                coins -=cost;
            }else break;
        }
        return res;
    }
}

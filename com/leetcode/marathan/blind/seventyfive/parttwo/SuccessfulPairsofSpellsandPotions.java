package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Arrays;

public class SuccessfulPairsofSpellsandPotions {
    public static void main(String[] args) {
        int [] spells = {5,1,3}, potions = {1,2,3,4,5};
        int success = 7;
        int [] res = successfulPairs(spells, potions, success);
        for(int i:res)
            System.out.print(i+", ");
    }

    private static int[] successfulPairs(int[] spells, int[] potions, int success) {
        int n = spells.length;
        int [] res = new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            //find the first valid index of the potion
            res[i] = successfulPairsBinarySearch(potions, success, spells[i]);
        }
        return res;
    }

    private static int successfulPairsBinarySearch(int[] potions, int success, int spell) {
        int m = potions.length;
        int l =0;
        int r = m-1;
        int firstValidIdx = m;
        while (l<=r){
            int mid = l+(r-l)/2;
            long strength = potions[mid]*spell;
            if(strength>=success){
                firstValidIdx = mid;
                r = mid-1;
            }else if(strength < success){
                l = mid+1;
            }
        }
        return m-firstValidIdx;
    }

//    private static int[] successfulPairs(int[] spells, int[] potions, int success) {
//        int n = spells.length;
//        int m = potions.length;
//        int [] res = new int[n];
//        for(int i=0;i<n;i++){
//            int count =0;
//            for(int j=0;j<m;j++){
//                int strength = spells[i]*potions[j];
//                if(strength >= success)count++;
//            }
//            res[i] = count;
//        }
//        return res;
//    }
}

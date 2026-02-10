package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        int h = 8;
        int minCount = minEatingSpeed(piles,h);
        System.out.println(minCount);
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        //find the max banan count
        int r = Integer.MIN_VALUE;
        for(int pile:piles) r = Math.max(r, pile);
        int l = 1; // min koko can eat 1 banana per hour
        while(l<r){
            int mid = l+(r-l)/2;
            if(canKokoEats(piles, h, mid)){
                r = mid;
            }else l =mid+1;
        }
        return l;
    }

    private static boolean canKokoEats(int[] piles, int h, int bananaCount) {
        int actualHour =0;
        for(int pile:piles){
            actualHour += pile/bananaCount;
            if(pile % bananaCount !=0)actualHour++;
        }
        return actualHour<=h;
    }
}

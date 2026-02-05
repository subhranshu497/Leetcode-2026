package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int [] flowerBed = {1,0,0,0,1};
        int n =1;
        boolean flag = canPlaceFlowers(flowerBed, n);
        System.out.println(flag);
    }

    private static boolean canPlaceFlowers(int[] flowerBed, int n) {
        int len = flowerBed.length;
        if(len==1 && flowerBed[0]==0 && n==1)return true;
        for(int i=0;i<len;i++){
            if(flowerBed[i]==1)continue;
            else if(n>0){
                if(i==0){
                    if(flowerBed[i+1]==0){
                        n -=1;
                        flowerBed[i] =1;
                    }
                }
                else if(i==len-1){
                    if(flowerBed[i-1]==0){
                        n -=1;
                        flowerBed[i] = 1;
                    }
                }
                else if(i+1<len && flowerBed[i-1]==0 && flowerBed[i+1]==0){
                    n -=1;
                    flowerBed[i] = 1;
                }
            }
        }
        return n==0;
    }
}

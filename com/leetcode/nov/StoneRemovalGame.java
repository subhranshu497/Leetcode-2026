package com.com.leetcode.nov;

public class StoneRemovalGame {
    public static void main(String[] args) {
        int n = 12;
        boolean flag = canAliceWin(n);
        System.out.println(flag);
    }

    private static boolean canAliceWin(int n) {
        int remove =10;
        boolean aliceTurn = true;
        while(n>=remove){
            n -=remove;
            remove--;
            aliceTurn = !aliceTurn;
        }
        return !aliceTurn;
    }
}

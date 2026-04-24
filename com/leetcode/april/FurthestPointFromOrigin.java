package com.com.leetcode.april;

public class FurthestPointFromOrigin {
    public static void main(String[] args) {
        String moves = "_R__LL_";
        int dist = furthestDistanceFromOrigin(moves);
        System.out.println(dist);
    }

    private static int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int rc =0;
        int lc =0;
        int dc=0;
        for(int i=0;i<n;i++){
            char ch = moves.charAt(i);
            if(ch=='R')rc++;
            else if(ch=='L')lc++;
            else dc++;
        }
        int diff = Math.abs(rc-lc);
        return diff + dc;
    }
}

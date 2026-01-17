package com.com.leetcode.jan;

public class largestSquareArea {
    public static void main(String[] args) {
        int [][] bottomLeft = {{1,1},{2,2},{3,1}};
        int [][] topRight = {{3,3},{4,4},{6,6}};
        long res = largestSquareAreaFn(bottomLeft, topRight);
    }

    private static long largestSquareAreaFn(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int y1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int x2 = Math.min(topRight[i][0], topRight[j][0]);
                int y2 = Math.min(topRight[i][1], topRight[j][1]);
                long w = x2-x1;
                long h = y2-y1;
                if(w>0 && h>0){
                   long side = Math.min(w,h);
                   maxSide = Math.max(side, maxSide);
                }
            }
        }
        return maxSide*maxSide;
    }
}

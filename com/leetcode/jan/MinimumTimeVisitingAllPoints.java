package com.com.leetcode.jan;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int [][] points = {{1,1},{3,4},{-1,0}};
        int count = minTimeToVisitAllPoints(points);
        System.out.println(count);
    }

    private static int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int distance = 0;
        for(int i=1;i<n;i++){
            int x1 = points[i-1][0];
            int y1 = points[i-1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];
            distance +=Math.max(Math.abs(y2-y1),Math.abs(x2-x1));
        }
        return distance;
    }
}

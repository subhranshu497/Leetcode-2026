package com.com.leetcode.april;

import java.util.Arrays;

public class MaximumWallsDestroyedbyRobots {
    public static void main(String[] args) {
        int [] robots = {10,2}, distance = {5,1}, walls = {5,2,7};
        int res = destroyWalls(robots, distance, walls);
        System.out.println(res);
    }

    private static int destroyWalls(int[] robots, int[] distance, int[] walls) {
        //create a 2d array to pair up the robots and distance
        int m = robots.length;
        int[][] robotDistance = new int[m][2];
        for(int i=0; i<m; i++){
            robotDistance[i][0] = robots[i];
            robotDistance[i][1] = distance[i];
        }
        //sort the robotDistance array based on the robot's power in ascending order
        Arrays.sort(robotDistance, (a, b)-> Integer.compare(a[0], b[0]));
        //sort the walls array in ascending order
        Arrays.sort(walls);
        //prepare the range array for the robots
        int[][] range = new int[m][2];
        for (int i=0;i<m;i++){
            int pos = robotDistance[i][0];
            int dist = robotDistance[i][1];

            int leftBound =(i==0)?1: robotDistance[i-1][0]+1;
            int rightBound =(i==m-1)?1000000000: robotDistance[i+1][0]-1;
            int left = Math.max(pos-dist, leftBound);
            int right = Math.min(pos+dist, rightBound);
            range[i][0] = left;
            range[i][1] = right;
        }
        int [][] memo = new int[m+1][2];
        for(int [] a: memo){
            Arrays.fill(a, -1);
        }
        //direction =0 - left , 1 = right
        return solve1(walls, range, robotDistance,0, 0, memo);
    }

    private static int solve1(int[] walls, int[][] range, int[][] robotDistance, int i, int prevDir, int [][] memo) {

        //base case
        if(i==robotDistance.length)
            return 0;
        if(memo[i][prevDir] != -1)
            return memo[i][prevDir];

        int left = range[i][0];

        //if the prev robot fired right
        if(prevDir == 1){
            left = Math.max(left,range[i-1][1]+1);
        }
        int leftRes = countWalls(walls, left, robotDistance[i][0])
                + solve1(walls, range, robotDistance, i+1, 0, memo);

        int rightRes = countWalls(walls, robotDistance[i][0], range[i][1])
                + solve1(walls, range, robotDistance, i+1, 1, memo);

        return memo[i][prevDir] =Math.max(leftRes, rightRes);

    }

    private static int countWalls(int[] walls, int l, int r) {
        int left = lowerBound(walls, l);
        int right = upperBound(walls, r);
        return right - left;
    }

    private static int upperBound(int[] walls, int target) {
        int l = 0, r = walls.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (walls[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private static int lowerBound(int[] walls, int target) {
        int l = 0, r = walls.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (walls[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;

    }
}

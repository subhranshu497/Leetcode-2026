package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTotalDistanceTraveled {
    public static void main(String[] args) {
        List<Integer> robot = new ArrayList<>(List.of(0, 4, 6));
        int[][] factory = {{2,2},{6,2}};
        long result = minimumTotalDistance(robot, factory);
        System.out.println(result); // Output the result
    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        //step 1 sort robot and factory
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->Integer.compare(a[0], b[0]));
        //step 2 - convert the 2d factory array to 1d array with factory position repeated by its capacity
        int n = robot.size();
        int m = factory.length;
        List<Integer> factoryCapacity = new java.util.ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int position = factory[i][0];
            int capacity = factory[i][1];
            for(int j=0;j<capacity;j++)
            {
                factoryCapacity.add(position);
            }
        }
        long [][] memo = new long[robot.size()][factoryCapacity.size()];
        for(long [] me:memo){
            Arrays.fill(me,-1);
        }

        //step 3 - calculate the total distance
        long totalDistance = solveMinDistRobot(robot, factoryCapacity,0,0,n, memo);
        return totalDistance;
    }
    private static long solveMinDistRobot(List<Integer> robot, List<Integer> factoryCapacity, int i, int j, int n, long [][] memo) {
        //base case
        if(i>=n) return 0;
        if(j>=factoryCapacity.size()) return Long.MAX_VALUE/2;
        if(memo[i][j]!=-1) return memo[i][j];
        //take the current robot and assign it to the current factory
        long take = Math.abs(robot.get(i) - factoryCapacity.get(j)) + solveMinDistRobot(robot, factoryCapacity, i+1, j+1, n, memo);
        long skip = solveMinDistRobot(robot, factoryCapacity, i, j+1, n, memo);
        return memo[i][j] = Math.min(take, skip);
    }
}

package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizetheDistanceBetweenPointsonaSquare {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 2}, {2, 0}, {2, 2}, {2, 1}};
        int k = 4;
        int side = 2;
        int dist = maxDistanceII(points, k, side);
        System.out.println(dist);
    }

    private static int maxDistanceII(int[][] points, int k, int side) {
        int n = points.length;
        long perimeter = 4L * side;
        int maxDist = 0;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            pos[i] = convertPointsToLinearDimension(points[i][0], points[i][1], side);
        }
        Arrays.sort(pos);
        //to avoid the circular move in the 1d array , lets doubled it
        long[] doublePos = new long[2 * n];
        for (int i = 0; i < n; i++) {
            doublePos[i] = pos[i];
            doublePos[i + n] = pos[i] + perimeter;
        }
        //binary search
        int l = 0, r = 2 * side;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (checkKPoints(doublePos, n, k, mid, side)) {
                maxDist = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return maxDist;
    }

    private static boolean checkKPoints(long[] doublePos, int n, int k, int mid, int side) {
        long perimeter = 4L * side;

        for (int i = 0; i < n; i++) {   // O(n)
            int count = 1;
            int idx = i;

            long lastPos = doublePos[idx];

            for (int j = 2; j <= k; j++) {   // O(k log n)
                long target = lastPos + mid;

                int nextIdx = lowerBound1(doublePos, idx + 1, i + n, target);

                if (nextIdx == i + n) break;

                idx = nextIdx;
                lastPos = doublePos[idx];
                count++;
            }

            if (count == k && (doublePos[i] + perimeter - lastPos >= mid)) {
                return true;
            }
        }

        return false;
    }

    private static int lowerBound1(long[] doublePos, int left, int right, long target) {
        int ans = right;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (doublePos[mid] >= target) {
                ans = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
    //    private static int maxDistanceII(int[][] points, int k, int side) {
//        int n = points.length;
//        int maxDist = 0;
//        //check all the combination of k points and choose k points of minimum manhattan distance
//        int l =0;
//        int r = 2*side;
//        while (l<=r){
//            int mid = l+(r-l)/2;
//            List<Integer> selected = new ArrayList<>();
//            if(checkKPoints(points, k, 0, mid, selected)) {
//                maxDist = mid;
//                l = mid + 1;
//            }else {
//                r = mid - 1;
//            }
//        }
//        return maxDist;
//    }
//
//    public static boolean checkKPoints(int[][] points, int k, int i, int mid, List<Integer> selected) {
//        //base condition
//        if (selected.size() == k) {
//            //check the manhattan distance of selected points
//            return true;
//        }
//        for (int idx = i; idx < points.length; idx++) {
//            boolean valid = true;
//            for (int selIdx : selected) {
//                int dist = calculateManhattanDistance(points[selIdx], points[idx]);
//                //since we r maximizing the m dist, so if the calculated dist is greater than mid,
//                // then we can consider this point as valid and add it to the selected list,
//                // otherwise we can skip this point and move to the next point
//                if (dist < mid) {
//                    valid = false;
//                    break;
//                }
//            }
//            if (!valid) {
//                continue;
//            }
//            selected.add(idx);
//            if (checkKPoints(points, k, idx + 1, mid, selected)) {
//                return true;
//            }
//            selected.remove(selected.size() - 1);
//        }
//        return false;
//    }

    private static long convertPointsToLinearDimension(int x, int y, int side) {
        int xDist =0;
        if(y==0)xDist =x;
        else if(x==side) xDist = side + y;
        else if(y==side) xDist = 3*side - x;
        else xDist = 4*side - y;
        return xDist;
    }
    private static int calculateManhattanDistance ( int[] point, int[] point1){
        int dist = Math.abs(point[0] - point1[0]) + Math.abs(point[1] - point1[1]);
        return dist;
    }
}

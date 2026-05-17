package com.com.leetcode.may;

public class JumpGameIII {
    public static void main(String[] args) {
        int [] arr = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }

    private static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        return canReachRecursion(arr, start,n);
    }

    private static boolean canReachRecursion(int[] arr, int i, int n) {
        //base case
        if(i>=n || i<0)return false;
        if(arr[i]==0) return true;
        if(arr[i]<0) return false; // visited
        //i have two option move forward or move backward
        //forward
        //track the index to avoid infinite loop
        //backtracking
        //do
        int jump = arr[i];
        arr[i] =-1; // visited
        //explore
        boolean forward= canReachRecursion(arr,i+jump,n);
        //move backward
        boolean backward= canReachRecursion(arr, i-jump,n);
        //undo
        arr[i] =jump;
        return forward || backward;
    }
}

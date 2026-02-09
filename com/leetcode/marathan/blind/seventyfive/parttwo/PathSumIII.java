package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        int target = 22;
        int count = pathSumIII(root, target);
        System.out.println(count);
    }

    private static int pathSumIII(TreeNode root, int target) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L,1);
        return pathSumThreeSolve(root, target, 0L,prefixSumMap);
    }

    private static int pathSumThreeSolve(TreeNode root, int target, long currentSum, Map<Long, Integer> prefixSumMap) {
        //base condition
        if(root==null) return 0;
        currentSum += root.val;
        int count = prefixSumMap.getOrDefault(currentSum-target,0);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum,0)+1);
        count += pathSumThreeSolve(root.left,target, currentSum, prefixSumMap);
        count += pathSumThreeSolve(root.right,target, currentSum, prefixSumMap);
        //undo
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum,0)-1);
        return count;
    }

    //brute force - double DFS
//    private static int pathSumIII(TreeNode root, int target) {
//        return pathSumThreeDfsone(root,target);
//    }
//
//    private static int pathSumThreeDfsone(TreeNode root, int target) {
//        if(root==null)return 0;
//        int mid = pathSumThreeDfsTwo(root,target, 0L);
//        int l = pathSumThreeDfsone(root.left,target);
//        int r = pathSumThreeDfsone(root.right,target);
//
//        return mid+l+r;
//    }
//
//    private static int pathSumThreeDfsTwo(TreeNode root, int target, long sum) {
//        if(root==null)return 0;
//        sum +=root.val;
//        int count =0;
//        if(sum==target) count= 1;
//        count += pathSumThreeDfsTwo(root.left,target, sum);
//        count += pathSumThreeDfsTwo(root.right,target,sum);
//
//        //sum -= root.val;
//        return count;
//    }
}

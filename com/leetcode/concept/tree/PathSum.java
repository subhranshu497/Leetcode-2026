package com.com.leetcode.concept.tree;

public class PathSum {
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
        int target = 22;
        boolean flag = hasPathSum(root, target);
        System.out.println(flag);
    }

    private static boolean hasPathSum(TreeNode root, int target) {
        return hasPathSumSolve(root, target, 0);
    }

    private static boolean hasPathSumSolve(TreeNode root, int target, int sum) {
        if(root==null) return false;
        sum += root.val;
        if(root.left == null && root.right==null) return target==sum;
        boolean l = hasPathSumSolve(root.left,target, sum);
        boolean r = hasPathSumSolve(root.right,target, sum);

        return l || r;
    }
}

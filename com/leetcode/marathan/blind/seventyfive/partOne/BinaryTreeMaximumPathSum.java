package com.com.leetcode.marathan.blind.seventyfive.partOne;

public class BinaryTreeMaximumPathSum {
    private static int max_sum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Tree root = new Tree(-10);
        root.left = new Tree(9);
        root.right = new Tree(20);
        root.right.left = new Tree(15);
        root.right.right = new Tree(7);
        int res = maxPathSum(root);
        System.out.println(res);
    }

    private static int maxPathSum(Tree root) {
        //max_sum = Integer.MIN_VALUE;
        if(root==null) return 0;
        maxPathSumDfs(root);
        return max_sum;
    }

    private static int maxPathSumDfs(Tree root) {
        if(root==null) return 0;
        int left_sum = maxPathSumDfs(root.left);
        int right_sum = maxPathSumDfs(root.right);
        //case 1 if down sum is good
        int down_sum = left_sum+right_sum+root.val;
        //case 2 if both left and right sum are -ve and root is +ve
        int only_root = root.val;
        //case 3 - if either left or right sum r good
        int either_left_or_right = Math.max(left_sum, right_sum)+root.val;

        max_sum = Math.max(max_sum,Math.max(down_sum,Math.max(only_root, either_left_or_right)));
        //down sum is complete but other two cases are not
        //so we have to choose between only root or either left or right sum
        return Math.max(only_root, either_left_or_right);
    }
}

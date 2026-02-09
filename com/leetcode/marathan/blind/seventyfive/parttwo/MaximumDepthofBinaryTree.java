package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int d = maxDepthI(root);
        System.out.println(d);
    }

    private static int maxDepthI(TreeNode root) {
        return calculateHeight(root);

    }

    private static int calculateHeight(TreeNode root) {
        if(root==null) return 0;
        int lh = 1+calculateHeight(root.left);
        int rh = 1+calculateHeight(root.right);
        return Math.max(lh, rh);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


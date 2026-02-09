package com.com.leetcode.feb;

import javax.swing.tree.DefaultMutableTreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>1)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int findHeight(TreeNode root) {
        if(root==null)return 0;
        int lh  =1+findHeight(root.left);
        int lr = 1+findHeight(root.right);
        return Math.max(lh, lr);
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

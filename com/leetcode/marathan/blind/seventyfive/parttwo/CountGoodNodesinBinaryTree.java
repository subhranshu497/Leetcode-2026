package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.ArrayList;
import java.util.List;

public class CountGoodNodesinBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        int count = goodNodes(root);
        System.out.println(count);
    }

    private static int goodNodes(TreeNode root) {
        return goodNodesSolve(root, Integer.MIN_VALUE);
    }

    private static int goodNodesSolve(TreeNode root, int currMax) {
        if(root == null)return 0;
        int goodCount =0;
        if(currMax<= root.val)
            goodCount +=1;
        currMax = Math.max(currMax, root.val);
        goodCount +=goodNodesSolve(root.left, currMax);
        goodCount +=goodNodesSolve(root.right, currMax);
        return goodCount;
    }
}

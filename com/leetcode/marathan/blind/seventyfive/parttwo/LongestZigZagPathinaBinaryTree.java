package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.Map;

public class LongestZigZagPathinaBinaryTree {
    private static int maxVal = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right= new TreeNode(1);

        int zigzag = longestZigZag(root);
        System.out.println(zigzag);
    }

    private static int longestZigZag(TreeNode root) {
        //in dfs left -true and right - false
        zigzagDfs(root.left,true,1);
        zigzagDfs(root.right,false,1);
        return maxVal;
    }

    private static void zigzagDfs(TreeNode root, boolean direction, int currLen) {
        if(root==null) return;
        maxVal = Math.max(maxVal, currLen);
        if(direction){
            zigzagDfs(root.right,false,currLen+1); // option 1
            zigzagDfs(root.left,true,1);
        }else{
            zigzagDfs(root.left,true,currLen+1);
            zigzagDfs(root.right,false,1);
        }

    }
}

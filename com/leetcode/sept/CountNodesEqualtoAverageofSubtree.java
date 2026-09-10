package com.com.leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class CountNodesEqualtoAverageofSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int count = averageOfSubtree(root);
        System.out.println(count);
    }

    private static int averageOfSubtree(TreeNode root) {
        //lets preorder traversal Root L R
        int [] res = new int[1];
        int [] sum = averageOfSubtreeDFS(root,res);
        return res[0];
    }
    private static int [] averageOfSubtreeDFS(TreeNode root, int [] res) {
        if(root==null) return new int[]{0,0};
        //do post order traversal
        int [] leftSum = averageOfSubtreeDFS(root.left,res);
        int [] rightSum = averageOfSubtreeDFS(root.right,res);
        int currentSum = leftSum[0]+rightSum[0]+root.val;
        int currentCount = leftSum[1]+rightSum[1]+1;
        if(currentSum/currentCount==root.val) res[0]++;

        return new int[]{currentSum, currentCount};
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

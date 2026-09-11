package com.com.leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class CountNodesEqualtoAverageofSubtree {
    private static int res;
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
        res =0;
        averageOfSubtreeDFS(root);
        return res;
    }

    private static int [] averageOfSubtreeDFS(TreeNode root) {
        if(root==null)return new int []{0,0};

        int [] lSum = averageOfSubtreeDFS(root.left);
        int [] rSum = averageOfSubtreeDFS(root.right);
        int totalSum = lSum[0]+rSum[0]+root.val;
        int totalCount= lSum[1]+rSum[1]+1;
        if(totalSum/totalCount==root.val)res++;

        return new int[]{totalSum, totalCount};
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

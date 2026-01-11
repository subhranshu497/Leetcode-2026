package com.jan;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        int level = maxLevelSum(root);
        System.out.println(level);
    }

    private static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum =Integer.MIN_VALUE;
        int level = 1;
        int currLevel = 1;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int currSum =0;
            while (size >0){
                TreeNode curr = q.poll();
                int currVal = curr.val;
                currSum +=currVal;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                size--;
            }
            if(currSum > sum){
                level = currLevel;
                sum = currSum;
            }
            currLevel++;
        }
        return level;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
    }
}
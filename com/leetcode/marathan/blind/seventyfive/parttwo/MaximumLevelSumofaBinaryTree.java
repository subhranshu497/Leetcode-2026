package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        int x = maxLevelSumI(root);
        System.out.println(x);
    }

    private static int maxLevelSumI(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        int currLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int levelSum =0;
            while(size-- >0){
                TreeNode curr = q.poll();
                levelSum +=curr.val;
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            currLevel +=1;
            if(maxSum<levelSum){
                maxSum = levelSum;
                level = currLevel;
            }
        }
        return level;
    }
}

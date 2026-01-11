package com.jan;

import com.sun.source.tree.Tree;

import java.util.*;

public class SmallestSubtreewithalltheDeepestNodes {
    private static int maxLevel = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);


        TreeNode res = subtreeWithAllDeepest(root);
    }

    private static TreeNode subtreeWithAllDeepest(TreeNode root) {
       //write a dfs and calculate the maxLevel
        Map<TreeNode, Integer> map = new HashMap<>();
        calculateLevelDFS(root, map,0);
        TreeNode res = subtreeWithAllDeepestDFS(root, map);
        return res;
    }

    private static TreeNode subtreeWithAllDeepestDFS(TreeNode root, Map<TreeNode, Integer> map) {
        //base condition
        if(root== null || map.getOrDefault(root, -1)==maxLevel)return root;

        TreeNode left = subtreeWithAllDeepestDFS(root.left, map);
        TreeNode right = subtreeWithAllDeepestDFS(root.right, map);
        if(left != null && right != null) return root;
        return left !=null?left:right;
    }

    private static void calculateLevelDFS(TreeNode root, Map<TreeNode, Integer> map, int currLevel) {
        //base condition
        if(root == null) return;
        map.put(root,currLevel);
        maxLevel = Math.max(maxLevel, currLevel);
        if(root.left != null){
            calculateLevelDFS(root.left, map, currLevel+1);
        }
        if(root.right != null){
            calculateLevelDFS(root.right, map, currLevel+1);
        }
    }
}

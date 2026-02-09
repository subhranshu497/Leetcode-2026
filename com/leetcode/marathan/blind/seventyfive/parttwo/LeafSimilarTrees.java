package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        boolean flag = leafSimilar(root1, root2);
        System.out.println(flag);
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        leafSimilarDFS(root1,list1);
        leafSimilarDFS(root2,list2);
        return list1.equals(list2);
    }

    private static void leafSimilarDFS(TreeNode root, List<Integer> list) {
        if(root==null)return;
        leafSimilarDFS(root.left,list);
        if(root.left==null && root.right==null)
            list.add(root.val);
        leafSimilarDFS(root.right,list);
    }
}

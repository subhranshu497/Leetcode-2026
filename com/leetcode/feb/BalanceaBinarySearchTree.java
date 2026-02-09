package com.com.leetcode.feb;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode node = balanceBST(root);
    }

    private static TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        TreeNode node = formTheBST(list, 0, list.size()-1);
        return node;
    }

    private static TreeNode formTheBST(List<Integer> list, int l, int r) {
        //base case
        if(l>r)return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = formTheBST(list, l, mid-1);
        root.right = formTheBST(list, mid+1, r);
        return root;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        //base case
        if(root==null) return;
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }
}

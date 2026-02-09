package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import com.sun.source.tree.Tree;

public class DeleteNodeinaBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        int key = 3;
        TreeNode res = deleteNode(root, key);
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        //reach to the node
        if(root == null) return root;
        if(key < root.val)
            root.left= deleteNode(root.left, key);
        else if(key > root.val)
            root.right =  deleteNode(root.right, key);
        else {
            if(root.left==null) return root.right;
            else if(root.right== null) return root.left;
            else {
                //find the min val from the right subtree .the left most node of right
                int min = findMinValFromRightLeftMost(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        }
        return root;
    }

    private static int findMinValFromRightLeftMost(TreeNode root) {
        int min =0;
        while(root != null){
            min = root.val;
            root = root.left;
        }
        return min;
    }
}

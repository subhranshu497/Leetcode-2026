package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class SearchinaBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left= new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val= 2;
        TreeNode res= searchBST(root,val);

    }

    private static TreeNode searchBST(TreeNode root, int val) {
        if(root== null)return null;
        if(val < root.val)
            return searchBST(root.left,val);
        else if(val >root.val)
            return searchBST(root.right, val);
        return root;
    }
}

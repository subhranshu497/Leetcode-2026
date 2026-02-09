package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import com.sun.source.tree.Tree;

public class LowestCommonAncestorofaBinaryTree {

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
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode lca = lowestCommonAncestorI(root, p,q);
    }

    //two cases
    //case 1 - p and q are siblings , in this case lca is root
    //cas 2 - either p is the parent of q or q is the parent of p . so in this case lca is parent node
    private static TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return root;
        if(root ==p) return p;
        if(root == q) return q;
        TreeNode left = lowestCommonAncestorI(root.left,p,q);
        TreeNode right = lowestCommonAncestorI(root.right,p,q);
        if(left !=null && right != null) return root;
        else if(left == null)return right;
        else return left;
    }
}

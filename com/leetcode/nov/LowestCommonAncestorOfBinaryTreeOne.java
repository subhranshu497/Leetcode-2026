package com.com.leetcode.nov;

public class LowestCommonAncestorOfBinaryTreeOne {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode res = lowestCommonAncestorOne(root,p,q);
    }

    private static TreeNode lowestCommonAncestorOne(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(p==root)return p;
        if(q==root) return q;
        TreeNode left = lowestCommonAncestorOne(root.left, p,q);
        TreeNode right = lowestCommonAncestorOne(root.right,p,q);
        if(left != null && right != null) return root;
        else if(left ==null) return right;
        return left;
    }
}
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
}

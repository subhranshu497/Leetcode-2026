package com.com.leetcode.concept.tree;



public class LowestCommonAncester {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode lca = lowestCommonAncestorBinaryTree(root, p,q);
    }

    private static TreeNode lowestCommonAncestorBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        //base condition
        if(root == null ||root==p || root==q)return root;

        TreeNode left = lowestCommonAncestorBinaryTree(root.left, p,q);
        TreeNode right = lowestCommonAncestorBinaryTree(root.right,p,q);

        if(left != null && right !=null) return root;
        if(right != null) return right;
        return left;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

}


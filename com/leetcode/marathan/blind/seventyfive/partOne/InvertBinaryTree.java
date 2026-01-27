package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Stack;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Tree root = new Tree(4);
        root.left = new Tree(2);
        root.right = new Tree(7);
        root.left.left = new Tree(1);
        root.left.right = new Tree(3);
        root.right.left = new Tree(6);
        root.right.right = new Tree(9);
        Tree res = invertTree(root);
    }

    private static Tree invertTree(Tree root) {
        if(root==null)return null;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        //swap
        Tree temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }


}
class Tree{
    int val;
    Tree left;
    Tree right;
    public Tree(){}
    public Tree(int val){
        this.val = val;
    }
    public Tree(Tree left, Tree right){
        this.left = left;
        this.right = right;
    }
}

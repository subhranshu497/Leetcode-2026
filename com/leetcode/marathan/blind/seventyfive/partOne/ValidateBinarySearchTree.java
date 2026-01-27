package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Tree root = new Tree(4);
        root.left = new Tree(2);
        root.right = new Tree(7);
        root.left.left = new Tree(1);
        root.left.right = new Tree(3);
        root.right.left = new Tree(6);
        root.right.right = new Tree(9);
        boolean flag = validateBST(root);
        System.out.println(flag);
    }

    private static boolean validateBST(Tree root) {
        List<Integer> list = new ArrayList<>();
        validateBSTDFS(root, list);

        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)) return false;
        }
        return true;
    }

    private static void validateBSTDFS(Tree root, List<Integer> list) {
        if(root == null) return;
        validateBSTDFS(root.left,list);
        list.add(root.val);
        validateBSTDFS(root.right, list);
    }
}
class Tree1{
    int val;
    Tree1 left;
    Tree1 right;
    public Tree1(){}
    public Tree1(int val){
        this.val = val;
    }
    public Tree1(Tree1 left, Tree1 right){
        this.left = left;
        this.right = right;
    }
}

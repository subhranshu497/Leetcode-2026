package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
    public static void main(String[] args) {
        Tree root = new Tree(4);
        root.left = new Tree(2);
        root.right = new Tree(7);
        root.left.left = new Tree(1);
        root.left.right = new Tree(3);
        root.right.left = new Tree(6);
        root.right.right = new Tree(9);
        int k =2;
        int kthSmall = kthSmallest(root,k);
        System.out.println(kthSmall);
    }

    private static int kthSmallest(Tree root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderOfBST(root, list);
        return list.get(k-1);
    }

    private static void inOrderOfBST(Tree root, List<Integer> list) {
        if(root==null) return;
        inOrderOfBST(root.left,list);
        list.add(root.val);
        inOrderOfBST(root.right, list);
    }
}

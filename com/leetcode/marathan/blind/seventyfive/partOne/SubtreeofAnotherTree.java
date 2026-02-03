package com.com.leetcode.marathan.blind.seventyfive.partOne;

import javax.swing.tree.TreeCellRenderer;

public class SubtreeofAnotherTree {

    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(4);
        root.right = new Tree(5);
        root.left.left = new Tree(1);
        root.left.right = new Tree(2);

        Tree subRoot = new Tree(9);
        subRoot.left = new Tree(1);
        subRoot.right = new Tree(2);

        boolean flag =isSubtree(root, subRoot);
        System.out.println(flag);
    }

    private static boolean isSubtree(Tree root, Tree subRoot) {
       return isSubTreeHelper(root, subRoot);
    }

    private static boolean isSubTreeHelper(Tree p, Tree q) {
        if(p==null) return false;
        if(isSameTreeI(p,q))return true;
        return isSubTreeHelper(p.left,q)||isSubTreeHelper(p.right, q);
    }
    private static boolean isSameTreeI(Tree p, Tree q){
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.val != q.val)return false;
        return isSameTreeI(p.left,q.left)&& isSameTreeI(p.right,q.right);
    }
}

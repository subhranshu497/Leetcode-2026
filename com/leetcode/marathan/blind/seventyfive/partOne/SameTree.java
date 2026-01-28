package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.List;

public class SameTree {
    public static void main(String[] args) {
        Tree p = new Tree(1);
        p.left = new Tree(2);

        Tree q = new Tree(1);
        q.right = new Tree(2);

        System.out.println(isSameTree(p,q));
    }

    private static boolean isSameTree(Tree p, Tree q) {
        if(p==null && q==null) return true;
        if(p ==null || q ==null || p.val !=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}

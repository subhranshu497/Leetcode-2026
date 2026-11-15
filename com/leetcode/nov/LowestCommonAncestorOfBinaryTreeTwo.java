package com.com.leetcode.nov;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfBinaryTreeTwo {
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(3);
        root.left = new TreeNodeI(5);
        root.left.left = new TreeNodeI(6);
        root.left.right = new TreeNodeI(2);
        root.left.right.left = new TreeNodeI(7);
        root.left.right.right = new TreeNodeI(4);
        root.right = new TreeNodeI(1);
        root.right.left = new TreeNodeI(0);
        root.right.right = new TreeNodeI(8);
        TreeNodeI p = new TreeNodeI(5);
        TreeNodeI q = new TreeNodeI(1);
        TreeNodeI res = lowestCommonAncestorTwo(root,p,q);
    }

    private static TreeNodeI lowestCommonAncestorTwo(TreeNodeI root, TreeNodeI p, TreeNodeI q) {
        Set<Integer> set = new HashSet<>();
        TreeNodeI res = lcaTwoDFS(root, p,q,set);
        return set.size()==2?res:null;
    }

    private static TreeNodeI lcaTwoDFS(TreeNodeI root, TreeNodeI p, TreeNodeI q, Set<Integer> set) {
        if(root==null) return null;
        TreeNodeI left = lcaTwoDFS(root.left,p,q,set);
        TreeNodeI right = lcaTwoDFS(root.right,p,q,set);
        if(p.val==root.val || q.val==root.val){
            set.add(root.val);
            return root;
        }
        if(left!=null && right!=null)return root;
        if(left==null) return right;
        return left;
    }
}
class TreeNodeI {
    TreeNodeI left;
    TreeNodeI right;
    int val;

    public TreeNodeI() {
    }

    public TreeNodeI(int val) {
        this.val = val;
    }
}
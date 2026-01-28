package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(9);
        root.right = new Tree(20);
        root.right.left = new Tree(15);
        root.right.right = new Tree(7);
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }

    private static List<List<Integer>> levelOrder(Tree root) {
        Queue<Tree> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> inner_list = new ArrayList<>();
            while(size >0){
                Tree curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                inner_list.add(curr.val);
                size--;
            }
            res.add(new ArrayList<>(inner_list));
        }
        return res;
    }
}

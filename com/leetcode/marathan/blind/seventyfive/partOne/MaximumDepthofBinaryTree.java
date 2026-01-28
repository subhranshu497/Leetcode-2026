package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(9);
        root.right = new Tree(20);
        root.right.left = new Tree(15);
        root.right.right = new Tree(7);
        int h  = maxDepth(root);
        System.out.println(h);
    }

    private static int maxDepth(Tree root) {
        int h =0;
         maxDepthDFS(root,h);
         return max;
    }

    private static void maxDepthDFS(Tree root, int h) {
        if(root==null){
            max= Math.max(max, h);
            return ;
        }
        maxDepthDFS(root.left, h+1);
        maxDepthDFS(root.right, h+1);
    }

//    private static int maxDepth(Tree root) {
//        Queue<Tree> q = new LinkedList<>();
//        int h = 0;
//        if(root==null)return 0;
//        q.add(root);
//        while(!q.isEmpty()){
//            int size = q.size();
//            while(size > 0){
//                Tree curr = q.poll();
//                if(curr.left != null) q.add(curr.left);
//                if(curr.right != null)q.add(curr.right);
//                size--;
//            }
//            h++;
//        }
//        return h;
//    }
}

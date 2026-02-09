package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import com.com.leetcode.marathan.blind.seventyfive.partOne.MinimumCostPathwithTeleportations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> res =rightSideView(root);
        System.out.println(res);
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            int last = 101;
            while(size>0){
                TreeNode curr =q.poll();
                last = curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }if(curr.right !=null){
                    q.add(curr.right);
                }
                size--;
            }
            res.add(last);
        }
        return res;
    }
}

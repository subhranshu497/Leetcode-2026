package com.com.leetcode.concept.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        int target = 22;
        List<List<Integer>> res = pathSumII(root, target);
        System.out.println(res);
    }

    private static List<List<Integer>> pathSumII(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        pathSumTwoSolve(root, target, res,0, new ArrayList<>());
        return res;
    }

    private static void pathSumTwoSolve(TreeNode root, int target, List<List<Integer>> res, int sum, List<Integer> list) {
        //base case
        if(root==null)return;

        sum +=root.val;
        list.add(root.val);
        //check for the leaf node if the sum equal to target
        if(root.left == null && root.right==null){
            if(sum==target){
                res.add(new ArrayList<>(list));
            }
        }else {
            pathSumTwoSolve(root.left,target, res, sum, list);
            pathSumTwoSolve(root.right,target, res, sum, list);
        }
        list.remove(list.size()-1);
    }
}

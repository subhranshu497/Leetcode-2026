package com.com.leetcode.feb;

import java.util.ArrayList;
import java.util.List;

public class SumofRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        int sum = sumRootToLeaf(root);
        System.out.println(sum);
    }

    private static int sumRootToLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        sumRootToLeafDfs(root, sb, list);
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    private static void sumRootToLeafDfs(TreeNode root, StringBuilder sb, List<Integer> list) {
        if(root==null){
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){
            int num = Integer.parseInt(sb.toString(),2);
            list.add(num);
        }else {
            sumRootToLeafDfs(root.left, sb, list);
            sumRootToLeafDfs(root.right, sb, list);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}

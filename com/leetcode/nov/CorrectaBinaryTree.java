package com.com.leetcode.nov;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CorrectaBinaryTree {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(8);
        root.left = new TreeNode1(3);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(7);
        root.left.right = null;
        root.right.left = new TreeNode1(9);
        root.right.right = new TreeNode1(4);
        root.left.left.left = new TreeNode1(2);
        root.left.left.right = null;
        root.right.left.left = new TreeNode1(5);
        root.right.left.right = new TreeNode1(6);

    }
    public TreeNode1 correctBinaryTree(TreeNode1 root) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(null, root));

        while (!q.isEmpty()) {
            Deque<Pair> next = new ArrayDeque<>();
            // Nodes already visited on this level
            Set<TreeNode1> seen = new HashSet<>();

            while (!q.isEmpty()) {
                Pair curr = q.poll();

                // Right child on this level marks the invalid node
                if (curr.node.right != null && seen.contains(curr.node.right)) {
                    // Detach the invalid node from its parent
                    if (curr.parent.left == curr.node) {
                        curr.parent.left = null;
                    } else {
                        curr.parent.right = null;
                    }
                    return root;
                }

                seen.add(curr.node);

                // Right first, so levels are visited right to left
                if (curr.node.right != null) {
                    next.add(new Pair(curr.node, curr.node.right));
                }
                if (curr.node.left != null) {
                    next.add(new Pair(curr.node, curr.node.left));
                }
            }
            q = next;
        }

        return root;
    }
    class Pair{
        TreeNode1 parent;
        TreeNode1 node;

        Pair(TreeNode1 parent, TreeNode1 node){
            this.parent = parent;
            this.node = node;
        }
    }

}

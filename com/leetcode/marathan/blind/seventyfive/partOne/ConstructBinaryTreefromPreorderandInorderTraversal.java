package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private static int idx =0;
    public static void main(String[] args) {
        int [] inorder = {9,3,15,20,7};
        int [] preorder = {3,9,20,15,7};
        Tree2 root = buildTree(inorder,preorder);
    }

    private static Tree2 buildTree(int[] inorder, int[] preorder) {
        int n = preorder.length;
        int rootVal = preorder[0];//3
        //convert inorder array to map so that fetching of index would be faster
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0;i<n;i++)
            inorderMap.put(inorder[i],i);
        Tree2 root = buildTreeRecursion(preorder, inorderMap,n,0,n-1);
        return root;
    }

    private static Tree2 buildTreeRecursion(int[] preorder, Map<Integer, Integer> inorderMap, int n, int st, int end) {
        //base case
        if(st>end) return null;
        if(idx >= n) return null;
        int rootVal = preorder[idx];
        idx++;
        int i = inorderMap.get(rootVal);
        Tree2 root = new Tree2(rootVal);
        root.left = buildTreeRecursion(preorder, inorderMap,n,st,i-1);
        root.right = buildTreeRecursion(preorder, inorderMap,n,i+1,end);
        return root;
    }

}
class Tree2{
    int val;
    Tree2 left;
    Tree2 right;
    public Tree2(){}
    public Tree2(int val){
        this.val = val;
    }
    public Tree2(Tree2 left, Tree2 right){
        this.left = left;
        this.right = right;
    }
}

package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.ArrayList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {
    private int i=0;

    public String serialize(Tree3 root) {
        //to serialize i would prefer preorder traversal
        StringBuilder sb = new StringBuilder();
        preorderDfs(root, sb);
        String s = "";
        if(sb.length()>0){
            s= sb.toString().substring(0,sb.length()-1);
        }
        return s;
    }
    private void preorderDfs(Tree3 root, StringBuilder sb) {
        //base case
        if(root==null){
            sb.append("*,");
            return;
        }
        sb.append(root.val).append(",");
        preorderDfs(root.left, sb);
        preorderDfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public Tree3 deserialize(String data) {
        if(data==null || data.isEmpty()) return null;
        String [] strArr = data.split(",");
        Tree3 root = deserializeHelper(strArr);
        return root;
    }

    private Tree3 deserializeHelper(String[] strArr) {
        if(strArr.length==i)return null;
        String str = strArr[i++];
        if(str.equals("*"))return null;
        Tree3 root = new Tree3(Integer.valueOf(str));
        root.left = deserializeHelper(strArr);
        root.right = deserializeHelper(strArr);

        return root;
    }
}
class Tree3{
    int val;
    Tree3 left;
    Tree3 right;
    public Tree3(){}
    public Tree3(int val){
        this.val = val;
    }
    public Tree3(Tree3 left, Tree3 right){
        this.left = left;
        this.right = right;
    }
}

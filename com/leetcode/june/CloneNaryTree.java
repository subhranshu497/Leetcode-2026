package com.com.leetcode.june;

import java.util.ArrayList;
import java.util.List;

public class CloneNaryTree {
    public Node cloneTree(Node root) {
        if(root==null) return null;
        Node copyNodeRoot = new Node(root.val);
        //start exploring the children
        for(Node child:root.children){
            Node copyNodeChild = cloneTree(child);
            copyNodeRoot.children.add(copyNodeChild);
        }
        return copyNodeRoot;
    }

}
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

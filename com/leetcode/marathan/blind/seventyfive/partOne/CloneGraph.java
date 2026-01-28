package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.*;

public class CloneGraph {

    //BFS
    public Node cloneGraph(Node node){
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            Node curr = q.poll();
            for(Node nei: curr.neighbors){
                if(!map.containsKey(nei)){
                    Node clone = new Node(nei.val);
                    map.put(nei,clone);
                    //cloneNode.neighbors.add(clone);
                    q.add(nei);
                }
                map.get(curr).neighbors.add(map.get(nei));
            }
        }
        return cloneNode;
    }


 //DFS
//    public Node cloneGraph(Node node){
//        if(node==null) return null;
//        Map<Node,Node> map = new HashMap<>();
//        Node cloneNode = new Node(node.val);
//        map.put(node, cloneNode);
//        //call dfs and traverse through its neighbor and create the nodes
//        cloneNoneDfs(node, cloneNode, map);
//
//        return cloneNode;
//    }

//    private void cloneNoneDfs(Node node, Node cloneNode, Map<Node, Node> map) {
//
//        for(Node n: node.neighbors){
//            if(!map.containsKey(n)){
//                Node clone = new Node(n.val);
//                map.put(n, clone);
//                cloneNode.neighbors.add(clone);
//                cloneNoneDfs(n,clone,map);
//            }else cloneNode.neighbors.add(map.get(n));
//        }
//    }

}
class Node {
public int val;
public List<Node> neighbors;
public Node() {
    val = 0;
    neighbors = new ArrayList<>();
}
public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
}
public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
}
}

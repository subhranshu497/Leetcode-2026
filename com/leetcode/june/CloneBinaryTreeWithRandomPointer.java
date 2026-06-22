import java.util.Map;

public class CloneBinaryTreeWithRandomPointer {
    Map<Node, NodeCopy> map = new java.util.HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
       return dfs(root);
    }

    private NodeCopy dfs(Node node) {
        if(node==null) return null;
        if(map.containsKey(node))
            return map.get(node);
        NodeCopy copy = new NodeCopy(node.val);
        map.put(node, copy);
        copy.left = dfs(node.left);
        copy.right = dfs(node.right);
        copy.random = dfs(node.random);

        return copy;
    }
}
class Node {
    int val;
    Node left;
    Node right;
    Node random;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.random = null;
    }
}
class NodeCopy {
    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;

    public NodeCopy(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.random = null;
    }
}

package com.com.leetcode.march;

import java.util.ArrayList;
import java.util.List;

class Excel {

    final Node[][] matrix;

    public Excel(int height, char width) {
        matrix = new Node[height][width - 'A' + 1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Node();
            }
        }
    }

    public void set(int row, char column, int val) {
        matrix[row - 1][column - 'A'].invalidate();
        matrix[row - 1][column - 'A'].val = val;
        matrix[row - 1][column - 'A'].children = null;
    }

    public int get(int row, char column) {
        return matrix[row - 1][column - 'A'].getValue();
    }

    public int sum(int row, char column, String[] numbers) {
        Node n = matrix[row - 1][column - 'A'];
        n.invalidate();
        n.children = new ArrayList<>();
        for (String s : numbers) {
            int ix = s.indexOf(":");
            if (ix != -1) {
                char c1 = s.charAt(0), c2 = s.charAt(ix + 1);
                int r1 = Integer.parseInt(s.substring(1, ix)), r2 = Integer.parseInt(s.substring(ix + 2, s.length()));
                for (int i = r1 - 1; i < r2; i++) {
                    for (int j = c1 - 'A'; j <= c2 - 'A'; j++) {
                        n.children.add(matrix[i][j]);
                        matrix[i][j].parents.add(n);
                    }
                }
            } else { // single num
                char c = s.charAt(0);
                int r = Integer.parseInt(s.substring(1, s.length()));
                n.children.add(matrix[r - 1][c - 'A']);
                matrix[r - 1][c - 'A'].parents.add(n);
            }
        }
        return n.getValue();
    }
}

class Node {
    List<Node> parents;
    List<Node> children;
    int val;
    boolean valid; // indicates whether we have already computed the val before

    Node() {
        parents = new ArrayList<>();
    }

    int getValue() {
        if (children == null) {
            return val;
        }
        if (valid) {
            return val;
        }
        int res = 0;
        for (Node c : children) {
            res += c.getValue();
        }
        valid = true;
        return val = res;
    }

    // note that I don't care to remove current node from parent list of nested children to keep the Solution clean
    // we don't care if we invalidate more than needed, constraints are still mild
    void invalidate() { // called on each update (set or sum)
        valid = false;
        if (parents != null) {
            for (Node p : parents) {
                p.invalidate();
            }
        }
    }
}
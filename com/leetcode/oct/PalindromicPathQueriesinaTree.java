package com.com.leetcode.oct;

import java.util.*;

public class PalindromicPathQueriesinaTree {
    public static void main(String[] args) {
        int n = 3;
        int [][]edges = {{0,1},{1,2}};
        String s = "aac";
        String [] queries = {"query 0 2","update 1 b","query 0 2"};
        List<Boolean> res = palindromePath(n, edges, s, queries);
        System.out.println(res); // expected [true, false]
    }

    private static List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] in = new int[n];
        int[] out = new int[n];
        int[] depth = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // Iterative DFS (root = 0): assigns Euler in/out times so each
        // subtree is a contiguous [in, out] range, plus depth/parent for LCA.
        boolean[] visited = new boolean[n];
        int[] childPtr = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int timer = 0;
        stack.push(0);
        visited[0] = true;
        in[0] = ++timer;
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (childPtr[node] < adj.get(node).size()) {
                int next = adj.get(node).get(childPtr[node]++);
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    depth[next] = depth[node] + 1;
                    in[next] = ++timer;
                    stack.push(next);
                }
            } else {
                out[node] = timer;
                stack.pop();
            }
        }

        int log = (int) (Math.log(Math.max(n, 2)) / Math.log(2)) + 2;
        int[][] up = new int[log][n];
        up[0] = parent.clone();
        for (int k = 1; k < log; k++) {
            for (int i = 0; i < n; i++) {
                int mid = up[k - 1][i];
                up[k][i] = (mid == -1) ? -1 : up[k - 1][mid];
            }
        }

        // Fenwick tree over Euler indices, range-XOR-update + point-XOR-query,
        // so query(in[node]) == XOR of charMask over every ancestor of node (root to node, inclusive).
        int[] bit = new int[n + 2];
        char[] cur = s.toCharArray();
        for (int i = 0; i < n; i++) {
            rangeXorUpdate(bit, n, in[i], out[i], charMask(cur[i]));
        }

        List<Boolean> results = new ArrayList<>();
        for (String query : queries) {
            String[] parts = query.split(" ");
            if (parts[0].equals("update")) {
                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                if (cur[node] != c) {
                    int delta = charMask(cur[node]) ^ charMask(c);
                    rangeXorUpdate(bit, n, in[node], out[node], delta);
                    cur[node] = c;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lca = lca(u, v, depth, up, log);
                // rootToU ^ rootToV cancels the shared root..lca segment (each node counted twice),
                // so XOR lca's own char back in once to recover the true u..v path parity.
                int mask = fenwickQuery(bit, in[u]) ^ fenwickQuery(bit, in[v]) ^ charMask(cur[lca]);
                results.add(Integer.bitCount(mask) <= 1);
            }
        }
        return results;
    }

    private static int charMask(char c) {
        return 1 << (c - 'a');
    }

    private static void fenwickAdd(int[] bit, int n, int i, int val) {
        for (; i <= n; i += i & (-i)) {
            bit[i] ^= val;
        }
    }

    private static int fenwickQuery(int[] bit, int i) {
        int res = 0;
        for (; i > 0; i -= i & (-i)) {
            res ^= bit[i];
        }
        return res;
    }

    private static void rangeXorUpdate(int[] bit, int n, int l, int r, int val) {
        fenwickAdd(bit, n, l, val);
        if (r + 1 <= n) fenwickAdd(bit, n, r + 1, val);
    }

    private static int lca(int u, int v, int[] depth, int[][] up, int log) {
        if (depth[u] < depth[v]) {
            int tmp = u; u = v; v = tmp;
        }
        int diff = depth[u] - depth[v];
        for (int k = 0; k < log; k++) {
            if (((diff >> k) & 1) == 1) u = up[k][u];
        }
        if (u == v) return u;
        for (int k = log - 1; k >= 0; k--) {
            if (up[k][u] != -1 && up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }
        return up[0][u];
    }
}

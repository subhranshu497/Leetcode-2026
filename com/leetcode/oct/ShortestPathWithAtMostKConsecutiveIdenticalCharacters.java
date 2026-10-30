package com.com.leetcode.oct;

import java.util.*;

public class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {
    public static void main(String[] args) {
        int n = 3;
        int [][] edges = {{0,1,1},{1,2,1},{0,2,3}};
        String labels = "aab";
        int k = 1;
        int res = shortestPath(n,edges,labels,k);
        System.out.println(res);
    }

    private static int shortestPath(int n, int[][] edges, String labels, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjList.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, weight});
        }

        // dist[node][count] = min total edge weight to reach `node` ending a run
        // of `count` consecutive identical characters; state (not just node) must
        // be tracked because the same node can be reached with different streaks,
        // and the streak controls which future edges remain valid.
        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1}); // {totalWeight, node, consecutiveSameCharCount}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long weight = curr[0];
            int node = (int) curr[1];
            int count = (int) curr[2];

            if (node == n - 1) {
                return (int) weight;
            }
            if (weight > dist[node][count]) continue; // stale entry

            for (int[] neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                int next = neighbor[0];
                int edgeWeight = neighbor[1];

                int nextCount = labels.charAt(next) == labels.charAt(node) ? count + 1 : 1;
                if (nextCount > k) continue;

                long nextWeight = weight + edgeWeight;
                if (nextWeight < dist[next][nextCount]) {
                    dist[next][nextCount] = nextWeight;
                    pq.offer(new long[]{nextWeight, next, nextCount});
                }
            }
        }

        return -1;
    }
}

package com.com.leetcode.jan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeIII {
    public static void main(String[] args) {
        int [][] maze = {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
        int [] ball = {4,3}, hole = {0,1};
        String str = findShortestWay(maze, ball, hole);
        System.out.println(str);
    }

    private static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        Node[][] best = new Node[m][n];

        // PriorityQueue sorts by distance, then by lexicographical path
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return Integer.compare(a.dist, b.dist);
            return a.path.compareTo(b.path);
        });

        pq.offer(new Node(ball[0], ball[1], 0, ""));

        // Sorted directions to help lexicographical requirements: d, l, r, u
        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        String[] ds = {"d", "l", "r", "u"};

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // Optimization: if we already found a better way to this cell
            if (best[curr.r][curr.c] != null &&
                    (best[curr.r][curr.c].dist < curr.dist ||
                            (best[curr.r][curr.c].dist == curr.dist && best[curr.r][curr.c].path.compareTo(curr.path) <= 0))) {
                continue;
            }

            best[curr.r][curr.c] = curr;
            if (curr.r == hole[0] && curr.c == hole[1]) continue;

            for (int i = 0; i < 4; i++) {
                int x = curr.r, y = curr.c, d = curr.dist;

                // Roll the ball
                while (x + dirs[i][0] >= 0 && x + dirs[i][0] < m &&
                        y + dirs[i][1] >= 0 && y + dirs[i][1] < n &&
                        maze[x + dirs[i][0]][y + dirs[i][1]] == 0) {
                    x += dirs[i][0];
                    y += dirs[i][1];
                    d++;
                    // Stop if we hit the hole while rolling
                    if (x == hole[0] && y == hole[1]) break;
                }

                pq.offer(new Node(x, y, d, curr.path + ds[i]));
            }
        }

        Node res = best[hole[0]][hole[1]];
        return res == null ? "impossible" : res.path;
    }
}
class Node {
    int r, c, dist;
    String path;

    Node(int r, int c, int dist, String path) {
        this.r = r;
        this.c = c;
        this.dist = dist;
        this.path = path;
    }
}

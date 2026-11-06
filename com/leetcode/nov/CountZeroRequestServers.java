package com.com.leetcode.nov;

import java.util.*;

public class CountZeroRequestServers {
    public static void main(String[] args) {
        int n =3;
        int [][] logs = {{1,3},{2,6},{1,5}};
        int x = 5;
        int [] queries = {10,11};
        int [] res = countServers(n,logs, x,queries);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int qLen = queries.length;
        int[] res = new int[qLen];

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        Integer[] order = new Integer[qLen];
        for (int i = 0; i < qLen; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> queries[a] - queries[b]);

        int[] requestCount = new int[n + 1];
        int activeServers = 0;
        int start = 0, end = 0;

        for (int idx : order) {
            int query = queries[idx];
            int lower = query - x;
            int upper = query;

            while (end < logs.length && logs[end][1] <= upper) {
                int server = logs[end][0];
                if (requestCount[server]++ == 0) activeServers++;
                end++;
            }
            while (start < end && logs[start][1] < lower) {
                int server = logs[start][0];
                if (--requestCount[server] == 0) activeServers--;
                start++;
            }

            res[idx] = n - activeServers;
        }

        return res;
    }
}

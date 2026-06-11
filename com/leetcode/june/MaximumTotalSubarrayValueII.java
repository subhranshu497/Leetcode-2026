package com.leetcode.june;

import java.util.*;

public class MaximumTotalSubarrayValueII {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 1};
        int k = 2;
        long res = maxTotalValue(nums, k);
        System.out.println(res);
    }

    public static long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SegmentTree stmin = new SegmentTree(nums, true);
        SegmentTree stMax = new SegmentTree(nums, false);
        //max heap will contain val, left idx and right idx
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //step 1 - intialize heap with the best val
        for (int l = 0; l < n; l++) {
            long val = getValueI(nums, l, n - 1, stmin, stMax);
            pq.offer(new int[]{(int) val, l, n - 1});
        }
        long res = 0;
        //step 2 - pop from pq and find best val
        while (k-- > 0) {
            int[] top = pq.poll();
            res += top[0];
            int l = top[1];
            int r = top[2];
            long nextBestVal = getValueI(nums, l, r - 1, stmin, stMax);
            pq.offer(new int[]{(int) nextBestVal, l, r - 1});
        }
        return res;
    }

    private static long getValueI(int[] nums, int l, int i, SegmentTree stmin, SegmentTree stMax) {
        if (l > i) return 0;
        long min = stmin.query(l, i);
        long max = stMax.query(l, i);
        return max - min;
    }
}

class SegmentTree {
    int[] segmentTree;
    int n;
    boolean isMinTree;

    public SegmentTree(int[] nums, boolean isMinTree) {
        this.isMinTree = isMinTree;
        this.n = nums.length;
        this.segmentTree = new int[4 * n];
        buildSegmentTree(nums, 0, n - 1, 0);
    }

    private void buildSegmentTree(int[] nums, int l, int r, int i) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(nums, l, mid, 2 * i + 1);
        buildSegmentTree(nums, mid + 1, r, 2 * i + 2);
        if (isMinTree) {
            segmentTree[i] = Math.min(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
        } else {
            segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
        }
    }

    public int query(int start, int end) {
        return querySegmentTree(start, end, 0, n - 1, 0);
    }

    private int querySegmentTree(int start, int end, int l, int r, int i) {
        if (l > end || r < start) {
            return isMinTree ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (l >= start && r <= end) {
            return segmentTree[i];
        }
        int mid = l + (r - l) / 2;
        if (isMinTree) {
            return Math.min(querySegmentTree(start, end, l, mid, 2 * i + 1),
                    querySegmentTree(start, end, mid + 1, r, 2 * i + 2));
        } else {
            return Math.max(querySegmentTree(start, end, l, mid, 2 * i + 1),
                    querySegmentTree(start, end, mid + 1, r, 2 * i + 2));
        }
    }
}

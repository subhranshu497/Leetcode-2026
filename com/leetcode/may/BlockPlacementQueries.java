package com.com.leetcode.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BlockPlacementQueries {
    private static int[] segmentTree;
    private static int n = 50000;
    public static void main(String[] args) {
        int [][] queries = {{2,1,1}};
        List<Boolean> res = getResults(queries);
        System.out.println(res);
    }

    static void constructSegmentTree() {
        segmentTree = new int[4 * n];
    }

    static void updateSegTree(int idx, int val, int i, int l, int r) {
        if(l == r) {
            segmentTree[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if(idx <= mid) {
            updateSegTree(idx, val, 2*i+1, l, mid);
        } else {
            updateSegTree(idx, val, 2*i+2, mid+1, r);
        }

        segmentTree[i] = Math.max(segmentTree[2*i+1], segmentTree[2*i+2]);
    }
    static int querySegTree(int start, int end, int i, int l, int r) {
        if(l > end || r < start) {
            return 0;
        }

        if(l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;

        return Math.max(querySegTree(start, end, 2*i+1, l, mid),
                querySegTree(start, end, 2*i+2, mid+1, r));
    }

    public static List<Boolean> getResults(int[][] queries) {
        constructSegmentTree();

        TreeSet<Integer> st = new TreeSet<>();
        st.add(0);

        List<Boolean> result = new ArrayList<>();

        for(int[] query : queries) {
            if(query[0] == 1) {
                int x = query[1];

                Integer nxtVal = st.higher(x);
                int nxt = (nxtVal != null) ? nxtVal : -1;
                int pre = st.lower(x) != null ? st.lower(x) : st.floor(x);

                updateSegTree(x, x - pre, 0, 0, n - 1);
                if(nxt != -1) updateSegTree(nxt, nxt - x, 0, 0, n - 1);

                st.add(x);
            } else {
                int x = query[1];
                int sz = query[2];

                int pre = st.floor(x);

                int maxGap = querySegTree(0, pre, 0, 0, n - 1);
                int best = Math.max(maxGap, x - pre);

                result.add(best >= sz);
            }
        }

        return result;
    }

    //brute force approach, can be optimized using segment tree or binary indexed tree
//    private static List<Boolean> getResults(int[][] queries) {
//        int n = queries.length;
//        Set<Integer> obstacles = new TreeSet<>();
//        obstacles.add(0);
//        List<Boolean> res = new ArrayList<>();
//        for(int [] query :queries){
//            int type = query[0];
//            int x = query[1];
//            if(type == 1){
//                obstacles.add(x);
//            }else{
//                int y = query[1];
//                int blockSize = query[2];
//                boolean found = false;
//                int prevObstacle = 0;
//                for(int currentObstacle:obstacles){
//                    if(currentObstacle > y)break;
//                    else if(blockSize <= currentObstacle - prevObstacle){
//                        found = true;
//                        break;
//                    }
//                    prevObstacle = currentObstacle;
//                }
//                if(!found){
//                    if(blockSize <= y-prevObstacle){
//                        found = true;
//                    }
//                }
//                res.add(found);
//            }
//        }
//        return res;
//    }
}

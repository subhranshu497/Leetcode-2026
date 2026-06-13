package com.com.geeksfor.geeks;

import java.util.ArrayList;
import java.util.List;

public class SumOfQueryII {
    private static int [] segmentTree;
    public static void main(String[] args) {
        int n = 4;
        int [] arr = {1,2,3,4};
        int [] queries = {1,4,2,3};
        int q =2;
        List<Integer> res = sumOfQueryII(n, arr, q, queries);
        System.out.println(res);
    }

    private static List<Integer> sumOfQueryII(int n, int[] arr, int q, int[] queries) {
        segmentTree = new int[4*n];
        List<Integer> res = new ArrayList<>();
        SegmentTree st = new SegmentTree();
        st.buildSegmentTree(arr, 0, n-1, 0);
        //at this point we have the segment tree built
        //now we can iterate over the queries and find the sum for each query
        for(int i=0; i<q*2;i +=2){
            int start = queries[i];
            int end = queries[i+1];
            //as it is a 1 index based array , so l =l-1 , r =r-1
            int sum = querySegmentTree(start-1, end-1, 0, n-1, 0);
            res.add(sum);
        }
        return res;
    }

    private static int querySegmentTree(int st, int end, int l, int r, int root) {
        //base case
        if(l>end || r<st)return 0;
        if(l>=st && r<=end){
            return segmentTree[root];
        }
        int mid = (l+r)/2;
        int leftchild = 2*root+1;
        int rightchild = 2*root+2;
        int leftSum = querySegmentTree(st, end, l, mid, leftchild);
        int rightSum = querySegmentTree(st, end, mid+1, r, rightchild);
        return leftSum + rightSum;
    }

    static class SegmentTree{
        public void buildSegmentTree(int [] arr, int l, int r , int node){
            if(l == r){
                segmentTree[node] = arr[l];
                return;
            }
            int mid = (l+r)/2;
            int leftchild = 2*node+1;
            int rightchild = 2*node+2;
            buildSegmentTree(arr, l, mid, leftchild);
            buildSegmentTree(arr, mid+1, r, rightchild);
            segmentTree[node] = segmentTree[leftchild] + segmentTree[rightchild];
        }
    }
}


package com.com.geeksfor.geeks;

public class RangeMinimumQuery {
    private static int [] segmentTree;

    public static void main(String[] args) {
        int n=4;
        int [] arr = {1,2,3,4};
        int [] queries = {0,3,1,2};
        int[] min = rangeMinimumQuery(n, arr, queries);
        for(int m : min){
            System.out.println(m);
        }
    }

    private static int[] rangeMinimumQuery(int n, int[] arr, int[] queries) {
        segmentTree = new int [4*n];
        int [] res = new int[queries.length/2];
        //step1 build the segment tree
        constructST(arr,0,n-1,0);
        //step2 - now we can iterate over the queries and find the minimum for each query
        int j=0;
        for(int i=0;i<queries.length;i+=2){
            int st = queries[i];
            int end = queries[i+1];
            //use the segment tree to find the minimum for the given range
            int min = querySgmentTree(st,end,0,n-1,0);
            res[j++] = min;
        }
        return res;
    }

    private static int querySgmentTree(int st, int end, int l, int r, int i) {
        //base case
        if(l>end || r<st)return Integer.MAX_VALUE;
        if(l>=st && r<=end)
            return segmentTree[i];
        if(l==r){
            return segmentTree[i];
        }
        int mid = (l+r)/2;

        int leftchild = 2*i+1;
        int rightchild = 2*i+2;
        int leftMin = querySgmentTree(st, end, l, mid, leftchild);
        int rightMin = querySgmentTree(st, end, mid+1, r, rightchild);
        return Math.min(leftMin, rightMin);
    }

    private static void constructST(int[] arr, int l, int r, int i) {
        //base case
        if(l == r){
            segmentTree[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        int leftchild = 2*i+1;
        int rightchild = 2*i+2;
        constructST(arr, l, mid, leftchild);
        constructST(arr, mid+1, r, rightchild);
        segmentTree[i] = Math.min(segmentTree[leftchild], segmentTree[rightchild]);
    }
}

package com.com.geeksfor.geeks;

public class UpdateQueryLazyPropagation {
    private static int[] segmentTree;
    private static int[] lazy;

    public static void main(String[] args) {
        int [] nums = {3,4,2,5,3,6,3,4};
        //q[0] = lbound, q[1] = ubound, q[2] = value to be added
        int [][] queries = {{1,3,2},{0,4,1},{2,5,3}};
        updateQueryLazyPropagation(nums, queries);
        System.out.println("Updated array after performing the queries:");
        for(int r : segmentTree){
            System.out.print(r+" ");
        }
    }

    private static void updateQueryLazyPropagation(int[] nums, int[][] queries) {
        int n = nums.length;
        segmentTree = new int[4*n];
        lazy = new int[4*n];
        //step 1 - build the segment tree
        buildSegmentTree(nums, 0, n-1, 0);
        //print the segment tree
        for(int i=0;i<segmentTree.length;i++){
            System.out.print(segmentTree[i]+" ");
        }
        //step 2 - now we can iterate over the queries and update the segment tree for each query
        for(int [] q : queries){
            int start = q[0];
            int end = q[1];
            int val = q[2];
            updateSegmentTree(start, end, val, 0, n-1, 0);
        }
    }

    private static void updateSegmentTree(int start, int end, int val, int l, int r, int i) {
        //use lazy propagation to update the segment tree
        //check if lazy[i] has value to be added to the segment tree
        //if yes then add that first to the segment tree and then propagate the value to the children
        //no of nodes = (r-l+1)
        //value to be added = no of nodes * value to be added
        if(lazy[i] != 0){
            int valToAdd = (r-l+1)*val;
            segmentTree[i] += valToAdd;
            //propagate the value to the children
            if(l != r){
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }
        //check for out of range
        if(l>end || r<start)return;
        //check for valid range
        if(start <=l && end >=r){
            int valToAdd = (r-l+1)*val;
            segmentTree[i] += valToAdd;
            if(l != r){
                lazy[2*i+1] += val;
                lazy[2*i+2] += val;
            }
            return;
        }
        int mid = (l+r)/2;
        updateSegmentTree(start, end, val, l, mid, 2*i+1);
        updateSegmentTree(start, end, val, mid+1, r, 2*i+2);
        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }

    private static void buildSegmentTree(int[] nums, int l, int r, int i) {
        //base case
        if(l == r){
            segmentTree[i] = nums[l];
            return;
        }
        int mid = (l+r)/2;
        int lc = 2*i+1;
        int rc = 2*i+2;
        buildSegmentTree(nums, l, mid, lc);
        buildSegmentTree(nums, mid+1, r, rc);
        segmentTree[i] = segmentTree[lc] + segmentTree[rc];
    }
}

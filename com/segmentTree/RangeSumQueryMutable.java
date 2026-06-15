package com.com.segmentTree;

public class RangeSumQueryMutable {
    private int [] segmentTree;
    private int n;
    private int [] nums;
    public RangeSumQueryMutable(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        segmentTree = new int[4*n];
        buildSegmentTreeI(0, n-1, 0, nums);
    }

    private void buildSegmentTreeI(int l, int r, int i, int[] nums) {
        //basecase
        if(l==r){
            segmentTree[i] = nums[l];
            return;
        }
        int mid = (l+r)/2;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        buildSegmentTreeI(l,mid,leftChild, nums);
        buildSegmentTreeI(mid+1, r, rightChild, nums);
        segmentTree[i] = segmentTree[leftChild] + segmentTree[rightChild];
    }
    public int sumRange(int left,int right){
        return querySegmentTreeI(left,right,0,n-1,0);
    }
    public void update(int index, int val){
        updateSegmentTreeI(index, val, 0, n-1, 0);
    }

    private void updateSegmentTreeI(int index, int val, int l, int r, int i) {
        //base case
        if(l==r){
            segmentTree[i] =val;
            return;
        }
        int mid = (l+r)/2;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        if(index <= mid){
            updateSegmentTreeI(index, val, l, mid, leftChild);
        }else{
            updateSegmentTreeI(index, val, mid+1, r, rightChild);
        }
        segmentTree[i] = segmentTree[leftChild] + segmentTree[rightChild];
    }


    private int querySegmentTreeI(int start, int end, int l, int r, int i) {
        //base case
        //check for out of range
        if(l>end || r<start)return 0;
        //check for valid range
        if(start <= l && end >= r){
            return segmentTree[i];
        }
        if(l==r){
            return segmentTree[i];
        }
        int mid = (l+r)/2;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int leftSum = querySegmentTreeI(start, end, l, mid, leftChild);
        int rightSum = querySegmentTreeI(start, end, mid+1, r, rightChild);
        return leftSum + rightSum;
    }
}

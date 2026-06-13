package com.com.leetcode.concept.SegmentTree;

public class SegmentTreeBuild {
        public static void main(String[] args) {
            int[] nums = {3,1,2,7};
            SegmentTree st = new SegmentTree(nums, nums.length);
            for (int val : st.segmentTree) {
                System.out.print(val + " ");
            }
        }
}
class SegmentTree{
    int [] segmentTree;
    int n;
    public SegmentTree(int[] nums, int n){
        this.n = n;
        segmentTree = new int[4*n];
        buildSegmentTree(nums, 0, n-1, 0);
    }

    private void buildSegmentTree(int[] nums, int l, int r, int node) {
        //base case
        if(l == r){
            segmentTree[node] = nums[l]; //leaf node
            return;
        }
        int mid = (l+r)/2;
        int leftchild = 2*node+1;
        int rightchild = 2*node+2;
        buildSegmentTree(nums,l,mid, leftchild);
        buildSegmentTree(nums, mid+1, r, rightchild);
        segmentTree[node] = segmentTree[leftchild] + segmentTree[rightchild]; //internal node
    }
}

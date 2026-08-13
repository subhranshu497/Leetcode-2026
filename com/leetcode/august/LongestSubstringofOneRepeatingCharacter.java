package com.com.leetcode.august;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringofOneRepeatingCharacter {

    static class Node {
        int maxLen;
        int prefisLen;
        int suffixLen;
        int size;
        Node(int size){
            this.size =size;
        }
    }
    public static void main(String[] args) {
        String queryCharacters = "aa";
        int [] queryIndices = {2,1};
        String s = "abyzz";
        int [] res = longestRepeating(queryCharacters, queryIndices,s);
        for(int r:res)
            System.out.println(r);
    }

    private static int[] longestRepeating(String queryCharacters, int[] queryIndices, String s) {
        int n = s.length();
        int k = queryCharacters.length();
        char [] charArr = s.toCharArray();
        Node [] tree = new Node[4*n];
        buildI(tree,0,0,n-1, charArr);
        int [] res = new int[k];
        for(int i=0;i<k;i++){
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            charArr[idx] = ch;
            updateI(tree,0,0,n-1,idx, charArr);
            res[i] = tree[0].maxLen;
        }
        return res;
    }

    private static void updateI(Node [] tree,int node, int l, int r, int idx, char[] charArr) {
        if(l==r) return;
        int mid = l+(r-l)/2;
        int leftChild = (2*node)+1;
        int rightChild = (2*node)+2;
        if(idx <= mid)
            updateI(tree,leftChild, l,mid,idx, charArr);
        else updateI(tree,rightChild,mid+1,r,idx, charArr);
        mergeII(tree[node],tree[leftChild], tree[rightChild],mid, charArr);
    }

    private static void buildI(Node [] tree, int node, int l, int r, char [] charArr) {
        tree[node] = new Node(r - l + 1);
        if(l==r){
            tree[node].maxLen = 1;
            tree[node].prefisLen =1;
            tree[node].suffixLen =1;
            return;
        }
        int mid = l+(r-l)/2;
        int leftChild = (2*node)+1;
        int rightChild = (2*node)+2;
        buildI(tree, leftChild,l,mid, charArr);
        buildI(tree,rightChild,mid+1, r, charArr);
        mergeII(tree[node],tree[leftChild], tree[rightChild],mid, charArr);
    }

    private static void mergeII(Node parent, Node left, Node right, int mid,char [] charArr) {
        parent.maxLen = Math.max(left.maxLen, right.maxLen);
        parent.prefisLen = left.prefisLen;
        parent.suffixLen = right.suffixLen;

        //check if char crosses the boundary
        if(charArr[mid]==charArr[mid+1]){
            parent.maxLen = Math.max(parent.maxLen, left.suffixLen+right.prefisLen);
            //if left is completely uniform and extends to right
            if(left.prefisLen == left.size){
                parent.prefisLen = left.size+ right.prefisLen;
            }
            //if right is uniform and extended to left
            if(right.prefisLen == right.size){
                parent.suffixLen = right.size+ left.suffixLen;
            }
        }
    }


//    private static int[] longestRepeating(String queryCharacters, int[] queryIndices, String s) {
//        int n = s.length();
//        int k = queryIndices.length;
//        int [] res = new int[k];
//        StringBuilder sb = new StringBuilder(s);
//        for(int i=0;i<k;i++){
//            char ch = queryCharacters.charAt(i);
//            int idx = queryIndices[i];
//            sb.setCharAt(idx, ch);
//            int len = calculateLongestSubstringLength(sb.toString());
//            res[i] = len;
//        }
//
//        return res;
//    }
//
//    private static int calculateLongestSubstringLength(String s) {
//        int n = s.length();
//        Map<Character, Integer> map = new HashMap<>();
//        int res=0;
//        int l=0;
//        int r =0;
//        while (l<n && r<n){
//            if(s.charAt(l) != s.charAt(r)){
//               l=r;
//            }
//            res = Math.max(res, r-l+1);
//            r++;
//        }
//        System.out.println("Longest substring with repeating character length"+res);
//        return res;
//    }
}

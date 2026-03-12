package com.com.leetcode.march;

import java.util.ArrayList;
import java.util.List;

public class MaximizeSpanningTreeStabilitywithUpgrades {
    public static void main(String[] args) {
        int n = 3, k = 1;
        int [][] edges = {{0,1,2,1},{1,2,3,0}};
        int res = maxStability(n, edges, k);
        System.out.println(res);
    }

    private static int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if(m==1){ // m ==1 must be in spanning tree
                if(dsu.find(u)==dsu.find(v))return -1;
                dsu.union(u,v);
            }
        }
        int result =-1;
        int l = 1;
        int r = 2*100000;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(checkForSpanningTree(n, edges,k,mid)){
                result = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return result;
    }

    private static boolean checkForSpanningTree(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);
        List<int[]> upgradeCandidates = new ArrayList<>();
        for(int [] edge:edges) {
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if(m==1){
                if(s<mid)return false;
                dsu.union(u,v);
            }
            else {
                if(s>=mid)dsu.union(u,v);
                else if(2*s >=mid){
                    upgradeCandidates.add(new int[]{u,v});
                }
            }
        }
        for(int [] edge:upgradeCandidates){
            int u = edge[0];
            int v = edge[1];
            if(dsu.find(u) != dsu.find(v)){
                if(k<=0) return false;
                dsu.union(u,v);
                k--;
            }
        }
        int root = dsu.find(0);
        for(int node =1;node <=n-1;node++){
            if(dsu.find(node) !=root) return false;
        }
        return true;
    }
}
class DSU{
    private int[] parent;
    private int[] rank;

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        //initially every node has its own parent and rank is zero
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] =0;
        }
    }
    public int find(int i){
        if(parent[i]==i) return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j){
        int parentOfi = find(i);
        int parentOfj = find(j);
        if(parentOfi != parentOfj){
            if(rank[parentOfi]<rank[parentOfj])
                parent[parentOfi] = parentOfj;
            else if(rank[parentOfj]<rank[parentOfi])
                parent[parentOfj] = parentOfi;
            else {
                parent[parentOfi] = parentOfj;
                rank[parentOfj]++;
            }
        }
    }
}

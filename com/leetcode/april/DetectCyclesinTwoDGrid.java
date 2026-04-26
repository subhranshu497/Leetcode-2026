package com.com.leetcode.april;

public class DetectCyclesinTwoDGrid {
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        char[][] grid = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        Solution solution = new Solution();
        boolean hasCycle = solution.containsCycle(grid);
        System.out.println(hasCycle);
    }
}
class Solution {
    boolean containsCycle(char[][] grid) {
        int n = grid[0].length;
        int m  = grid.length;
        DSU dsu = new DSU(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //check right
                if(j+1<n && grid[i][j]==grid[i][j+1]){
                    //check for union
                    //if union returns false, it mean nodes are connected earlier , so return true
                    int u = i*n+j;
                    int v = (i*n)+(j+1);
                    if(!dsu.union(u,v)){
                        return true;
                    }
                }
                //check down
                if(i+1<m && grid[i][j]==grid[i+1][j]){
                    //check for union
                    //if union returns false, it mean nodes are connected earlier , so return true
                    int u = i*n+j;
                    int v = ((i+1)*n)+(j);
                    if(!dsu.union(u,v)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    class DSU{
        int [] parent;
        int [] rank;
        int n;
        public DSU(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] =i;
                rank[i] = 1;
            }
        }
        //find parent
        public int findParent(int p){
            if(parent[p]==p) return p;
            return parent[p] = findParent(parent[p]);
        }
        //union
        public boolean union(int u, int v){
            int parent_u = findParent(u);
            int parent_v = findParent(v);
            if(parent_u==parent_v) return false; //already connected. cycle presnet
            if(rank[parent_u]>rank[parent_v]) {
                parent[parent_v] = parent_u; // jiska rank bada hoga, woh papa banega
            }else if(rank[parent_u]<rank[parent_v]) {
                parent[parent_u] = parent_v;
            }else{
                parent[parent_v] = parent_u;
                rank[parent_u]++;
            }
            return true;
        }
    }
}

package com.com.leetcode.april;

import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations {
    public static int n;
    public static void main(String[] args) {
        int [] source = {1, 2, 3, 4};
        int [] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};
        int result = minimumHammingDistance(source, target, allowedSwaps);
        System.out.println("Minimum Hamming Distance: " + result); // Output the result
    }

    private static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        n = source.length;
        DSU dsu = new DSU(n);
        for(int [] swap: allowedSwaps){
            dsu.union(swap[0], swap[1]);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int parent = dsu.find(i);
            map.putIfAbsent(parent, new HashMap<>());
            Map<Integer, Integer> freqMap = map.get(parent);
            freqMap.put(source[i], freqMap.getOrDefault(source[i], 0)+1);
        }
        // Calculate the Hamming distance
        int hammingDistance = 0;
        for(int i=0; i<n; i++){
            int parent = dsu.find(i);
            Map<Integer, Integer> freqMap = map.get(parent);
            if(freqMap.getOrDefault(target[i], 0) > 0){
                freqMap.put(target[i], freqMap.get(target[i]) - 1);
            } else {
                hammingDistance++;
            }
        }
        return hammingDistance;
    }
}
class DSU{
    int [] parent;
    int [] rank;
    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x]= find(parent[x]);
    }
    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) {
            return;
        } else if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
    }
}

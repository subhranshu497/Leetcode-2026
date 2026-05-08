package com.com.leetcode.may;

import java.util.*;

public class MinimumJumpstoReachEndviaPrimeTeleportation {
    public static void main(String[] args) {
        int [] nums = {2,3,4,7,9};
        int jumps = minJumps(nums);
        System.out.println(jumps);
    }

    private static int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Map: Value -> List of Indices where that value appears
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            valToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            maxVal = Math.max(maxVal, nums[i]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> visitedPrimes = new HashSet<>(); // Optimization: don't process same prime twice

        q.offer(0);
        visited[0] = true;
        int jumps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();

                if (i == n - 1) return jumps;

                // 1. Adjacent Steps
                if (i + 1 < n && !visited[i + 1]) {
                    if (i + 1 == n - 1) return jumps + 1;
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // 2. Prime Teleportation
                int val = nums[i];
                if (isPrime(val) && !visitedPrimes.contains(val)) {
                    visitedPrimes.add(val);
                    // Jump to all multiples of this prime
                    for (int mult = val; mult <= maxVal; mult += val) {
                        if (valToIndices.containsKey(mult)) {
                            for (int nextIdx : valToIndices.get(mult)) {
                                if (!visited[nextIdx]) {
                                    if (nextIdx == n - 1) return jumps + 1;
                                    visited[nextIdx] = true;
                                    q.offer(nextIdx);
                                }
                            }
                            // Optimization: Once we visit all indices of a multiple via a prime,
                            // we don't need to visit them again from another prime.
                            // But be careful: a multiple can be reached by DIFFERENT primes.
                            // To be safe, we clear the map entry ONLY if we're sure.
                        }
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        int range = (int) Math.sqrt(num);
        for (int i = 3; i <= range; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    private static boolean isPrimeSeive(int num, int[] seive) {
        if(num < 2) return false;
        if(seive[num] == 0){
            for(int i=2;i<=num/2;i++){
                if(num%i == 0){
                    seive[num] = 1;
                    return false;
                }
            }
        }
        return true;
    }
}

package com.com.leetcode.feb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class MinimumOperationstoEqualizeBinaryString {
    public static void main(String[] args) {
        String s = "0100";
        int k = 1;
        int ans = minimumOperations(s, k);
        System.out.println(ans);
    }

    private static int minimumOperations(String s, int k) {
        int n = s.length();
        //if there are z no of 0's r there
        //f= no of zero we are flipping in k bits
        //k-f one's picked and flipped to zero
        // in the new state of string no of zero = z-f+k-f = z+k-2f
        //as there are total z zeros , so f<=z
        //at max we can flip k bits so f<=k
        //f = min(z,k)
        //zeros = z
        //ones = n-z
        //no of ones flipped = k-f
        // k-f <= n-z
        // f >= k-(n-z) = k-n+z
        // f >= max(0,k-n+z)

        int z = 0;
        for(char c : s.toCharArray()){
            if(c=='0'){
                z++;
            }
        }
        if(z==0) return 0;
        int [] ops = new int[n+1];
        Arrays.fill(ops, -1);
        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();
        for (int i =0;i<=n;i++){
            if(i%2==0){
                even.add(i);
            }else {
                odd.add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(z);
        ops[z] = 0;
        if(z%2==0){
            even.remove(z);
        }else {
            odd.remove(z);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            int minNewZ = curr+k-2*Math.min(curr,k);
            int maxNewZ = curr+k-2*Math.max(0,k-n+curr);
            TreeSet<Integer> set = (minNewZ%2==0)?even:odd;
            Integer next = set.ceiling(minNewZ);
            while(next!=null && next<=maxNewZ){
                int newCurr  = next;
                ops[newCurr] = ops[curr]+1;
                if(newCurr == 0){
                    return ops[newCurr];
                }
                q.offer(newCurr);
                set.remove(next);
                next = set.ceiling(minNewZ);
            }
        }
        return -1;
    }
}

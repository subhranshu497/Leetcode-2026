package com.com.leetcode.may;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JumpGameIV {
    public static void main(String[] args) {
        int[] arr ={7,6,9,6,9,6,9,7};
        int jump = minJumpsIV(arr);
        System.out.println(jump);
    }

    private static int minJumpsIV(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
        boolean [] visited = new boolean[n];
        Map<Integer, List<Integer>> map = IntStream.range(0,n)
                        .boxed()
                                .collect(Collectors.groupingBy(
                                        i->arr[i]
                                ));
        System.out.println(map);
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- >0){
                int curr = q.poll();
                if(curr+1 <n && !visited[curr+1]){
                    if(curr+1 == n-1)return steps+1;
                    visited[curr+1] = true;
                    q.add(curr+1);
                }
                if(curr-1>=0 && !visited[curr-1]){
                    if(curr-1 == n-1)return steps+1;
                    visited[curr-1] = true;
                    q.add(curr-1);
                }
                List<Integer> list = map.get(arr[curr]);
                if(list != null){
                    for(int idx:list){
                        if(!visited[idx]){
                            if(idx == n-1)return steps+1;
                            visited[idx] = true;
                            q.add(idx);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            steps +=1;
        }
        return steps;
    }


//    private static void minJumpRecursion(int n, int[] arr, int i, boolean[] visited, Map<Integer, List<Integer>> map, int steps) {
//        //base case
//        if(i<0 || i>=n || visited[i]){
//            return;
//        }
//        if(i==n-1){
//            count = Math.min(count, steps);
//            return;
//        }
//        if(steps>=count)return;
//        //start backtracking .
//        //step 1 - do
//        visited[i] =true;
//        //step - 2 - execute
//        //move forward and move backward
//        minJumpRecursion(n,arr,i+1,visited,map,steps+1);
//        minJumpRecursion(n,arr,i-1,visited,map,steps+1);
//        List<Integer> indexList = map.get(arr[i]);
//        if(indexList != null){
//            List<Integer> copyList = List.copyOf(indexList);
//            for(int idx:copyList){
//                if(idx != i)
//                    minJumpRecursion(n, arr, idx,visited,map, steps+1);
//            }
//        }
//        //step - 3 undo
//        visited[i] = false;
//    }
}

package com.com.leetcode.march;

import java.util.*;

public class MRUQueue {
    private int n ;
    private List<Integer> list;
    public MRUQueue(int n){
        this.n = n;
        list = new LinkedList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
    }

    public int fetch(int k){
        int ele = list.get(k-1);
        list.remove(k-1);
        list.addLast(ele);

        return ele;
    }
}
class Driver{
    public static void main(String[] args) {
        MRUQueue mruQueue = new MRUQueue(8);
        int res1 = mruQueue.fetch(3);
        System.out.println(res1);
        int res2 = mruQueue.fetch(5);
        System.out.println(res2);
        int res3 = mruQueue.fetch(2);
        System.out.println(res3);
        int res4 = mruQueue.fetch(8);
        System.out.println(res4);

    }
}

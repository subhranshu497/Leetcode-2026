package com.com.leetcode.april;

import java.util.List;

public class ZigzagIterator {
    List<Integer> v1;
    List<Integer> v2;
    int n1;
    int n2;
    int i;
    int j;
    boolean turn;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        n1 = v1.size();
        n2 = v2.size();
        i=0;
        j=0;
        turn = true;
    }
    public int next() {
        if (i >= v1.size()) return v2.get(j++);
        if (j >= v2.size()) return v1.get(i++);
            if(turn){
                turn = false;
                return v1.get(i++);
            } else {
                turn = true;
                return v2.get(j++);
            }
    }
    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }

}

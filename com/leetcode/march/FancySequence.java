package com.com.leetcode.march;

import java.util.ArrayList;
import java.util.List;

public class FancySequence {
    private int MOD = 1000000007;
    private long add;
    private long multiplier;

    //Fermat little theorem and binary exponentiation
    long powerCalculation(long a, long b){
        if(b==0) return 1;
        long half = powerCalculation(a, b/2);
        long res = (half*half)%MOD;

        if(b % 2 ==1) res = (res*a)%MOD;
        return res;
    }
    List<Long> seq;
    public FancySequence() {
        this.add =0;
        this.multiplier =1;
        seq = new ArrayList<>();
    }

    public void append(int val) {
        long x = (((val-add)%MOD)+MOD)*powerCalculation(multiplier, MOD-2)%MOD;
        seq.add(x);
    }

    public void addAll(int inc) {
        add = (add+inc)%MOD;
    }

    public void multAll(int m) {
        multiplier =(multiplier*m)%MOD;
        add = (add*m)%MOD;
    }

    public int getIndex(int idx) {
        if(idx >=seq.size()) return -1;
        long x = seq.get(idx);
        long x_ = ((x*multiplier)+add)%MOD;

        return (int) x_;
    }
}

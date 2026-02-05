package com.com.leetcode.feb;

public class DesignHitCounter {
    private int [] time;
    private int [] hits;
    public DesignHitCounter() {
        time = new int[300];
        hits = new int[300];
    }
    public void hit(int timestamp) {
        //when hit is coming , first need to check the time stamp and if it is present in the buffer
        int idx = timestamp%300;
        if(time[idx] != timestamp){
            time[idx] = timestamp;
            hits[idx] = 1;
        }else {
            hits[idx]++;
        }
    }
    public int getHits(int timestamp) {
        int hitCount =0;
        for(int i=0;i<300;i++){
            if(timestamp-time[i] <300){
                hitCount +=hits[i];
            }
        }
        return hitCount;
    }
}

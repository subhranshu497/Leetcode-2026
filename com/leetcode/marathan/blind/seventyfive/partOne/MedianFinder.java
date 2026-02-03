package com.com.leetcode.marathan.blind.seventyfive.partOne;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek())maxHeap.add(num);
        else{
            minHeap.add(num);
        }
        //always maintain the maxh size >= min h size
        if(maxHeap.size()-minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    double findMedian() {
        int maxHeapSize = 0;
        int minHeapSize =0;
        if(!maxHeap.isEmpty())maxHeapSize = maxHeap.size();
        if(!minHeap.isEmpty())minHeapSize = minHeap.size();
        int sum = maxHeapSize+minHeapSize;
        if(sum % 2 != 0){
            return maxHeap.peek();
        }
        else{
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}

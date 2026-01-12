package com.com.leetcode.jan;

import java.util.*;

class Leaderboard {
    Map<Integer,Integer> scoremap;
    PriorityQueue<Integer> pq;

    public Leaderboard() {
        this.scoremap = new HashMap<>();
        this.pq = new PriorityQueue<>(
                new Comparator<Integer>(){
                    public int compare(Integer u, Integer v){
                        return scoremap.get(v) - scoremap.get(u);
                    }
                }
        );
    }

    public void addScore(int playerId, int score) {
        scoremap.put(playerId,
                score + scoremap.getOrDefault(playerId, 0));
        if (pq.contains(playerId)){
            pq.remove(playerId);
        }
        pq.offer(playerId);
    }

    public int top(int K) {
        List<Integer> saved = new ArrayList<>();
        int cnt = 0, totscore = 0;
        while (!pq.isEmpty() && cnt < K){
            int topper = pq.poll();
            saved.add(topper);
            totscore += scoremap.get(topper);
            cnt += 1;
        }
        for(int x: saved){
            pq.offer(x);
        }
        return totscore;
    }

    public void reset(int playerId) {
        scoremap.put(playerId, 0);
        pq.remove(playerId);
    }
}

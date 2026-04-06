package com.com.leetcode.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {
    public static void main(String[] args) {
        List<Integer> pid = List.of(1, 3, 10, 5);
        List<Integer> ppid = List.of(3, 0, 5, 3);
        int kill = 5;
        List<Integer> res = killProcess(pid, ppid, kill);
        System.out.println(res);
    }

    private static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        //prepare the N-ary tree
        for(int i=0; i<pid.size(); i++){
            int parent = ppid.get(i);
            int child = pid.get(i);
            map.computeIfAbsent(parent, k->new ArrayList<>()).add(child);
        }
        //now we have the N-ary tree, we can do DFS to find all the children of the kill node
        List<Integer> res = new ArrayList<>();
        dfsToFindAllKilledNodes(map, kill, res);
        return res;
    }

    private static void dfsToFindAllKilledNodes(Map<Integer, List<Integer>> map, int kill, List<Integer> res) {
        res.add(kill);
        if(map.containsKey(kill)){
            for(int child : map.get(kill)){
                dfsToFindAllKilledNodes(map, child, res);
            }
        }
    }
}

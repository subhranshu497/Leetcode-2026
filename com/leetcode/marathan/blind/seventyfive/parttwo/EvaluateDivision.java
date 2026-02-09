package com.com.leetcode.marathan.blind.seventyfive.parttwo;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        double [] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        List<List<String>> equations = new ArrayList<>();
        List<String> l1= List.of("a","b");
        equations.add(new ArrayList<>(l1));
        List<String> l2= List.of("b","c");
        equations.add(new ArrayList<>(l2));

        double [] res = calcEquation(equations, values,queries);
        for(double r:res)
            System.out.print(r+", ");
    }

    private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adjList = new HashMap<>();
        int i =0;
        for(List<String> equation:equations){
            String u = equation.get(0);
            String v = equation.get(1);
            adjList.computeIfAbsent(u, p->new ArrayList<>()).add(new Pair(v, values[i]));
            adjList.computeIfAbsent(v, p->new ArrayList<>()).add(new Pair(u, 1/values[i]));
            i++;
        }
        double[] res = new double[queries.size()];

        //traverse the queries

        i =0;
        for(List<String> query:queries){
            double calculatedCost =1.0;
            double [] tempAns = new double[]{-1.0};
            if(adjList.containsKey(query.get(0))){
                Set<String> visited = new HashSet<>();
                calcEqDfs(adjList, query.get(0),query.get(1), calculatedCost, tempAns, visited);
            }
            res[i++] =tempAns[0];
        }
        return res;
    }

    private static void calcEqDfs(Map<String, List<Pair>> adjList, String u, String v, double calculatedCost, double[] tempAns, Set<String> visited) {
        //base condition
        if(visited.contains(u))return;
        visited.add(u);
        if(u.equals(v)){
            tempAns[0] =calculatedCost;
            return;
        }
        for(Pair p:adjList.getOrDefault(u,new ArrayList<>())){
            String tempV = p.node;
            double cost = p.val;
            calcEqDfs(adjList, tempV,v,cost*calculatedCost,tempAns, visited);
        }
    }
}
class Pair{
    String node;
    double val;
    public Pair(String node, double val){
        this.node = node;
        this.val = val;
    }
}
